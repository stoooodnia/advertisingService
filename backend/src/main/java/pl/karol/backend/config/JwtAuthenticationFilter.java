package pl.karol.backend.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull jakarta.servlet.http.HttpServletRequest request,
            @NonNull jakarta.servlet.http.HttpServletResponse response,
            @NonNull jakarta.servlet.FilterChain filterChain
    ) throws ServletException, IOException {

        String token = null;
        String username;

        if (request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                if(cookie.getName().equals("authToken")){
                    token = cookie.getValue();
                }
            }
        }
        if (token == null){
            filterChain.doFilter(request, response);
            return;
        }
        username = jwtService.extractUsername(token);
        if (username != null) {
            // set authentication
            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request, response);
    }
}
