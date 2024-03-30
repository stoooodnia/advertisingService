package pl.karol.backend.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.karol.backend.config.JwtService;
import pl.karol.backend.token.Token;
import pl.karol.backend.token.TokenRepository;
import pl.karol.backend.user.Role;
import pl.karol.backend.user.User;
import pl.karol.backend.user.UserRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    private final Integer EXPIRATION_TIME = Integer.valueOf(System.getenv("EXPIRATION_TIME"));
    private final Integer REFRESH_EXPIRATION_TIME = Integer.valueOf(System.getenv("REFRESH_EXPIRATION_TIME"));


    public AuthenticationResponse register(RegisterRequest request, HttpServletResponse response) throws Exception {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new Exception();
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(user, token);
        // Cookies
        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(REFRESH_EXPIRATION_TIME)
                .build();
        ResponseCookie authCookie = ResponseCookie.from("authToken", token)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(EXPIRATION_TIME)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());
        response.addHeader(HttpHeaders.SET_COOKIE, authCookie.toString());
        return AuthenticationResponse.builder()
                .user(user)
                .build();

    }


    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, token);
        ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(REFRESH_EXPIRATION_TIME)
                .build();
        ResponseCookie authCookie = ResponseCookie.from("authToken", token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(EXPIRATION_TIME)
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());
        response.addHeader(HttpHeaders.SET_COOKIE, authCookie.toString());
        return AuthenticationResponse.builder()
                .user(user)
                .build();
    }



    public void refresh(
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        String refreshToken = null;
        String userEmail;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("refreshToken")) {
                    refreshToken = cookie.getValue();
                }
            }
        }
        if (refreshToken == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = userRepository.findByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var token = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, token);
                ResponseCookie authCookie = ResponseCookie.from("authToken", token)
                        .httpOnly(true)
                        .secure(false)
                        .path("/")
                        .maxAge(EXPIRATION_TIME)
                        .build();
                response.addHeader(HttpHeaders.SET_COOKIE, authCookie.toString());
            }
    }

    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}
