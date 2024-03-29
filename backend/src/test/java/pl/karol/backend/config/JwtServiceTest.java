package pl.karol.backend.config;

import org.junit.jupiter.api.Test;
import pl.karol.backend.user.Role;
import pl.karol.backend.user.User;


import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {


    private final JwtService jwtService = new JwtService();
    private final String username = "testUser@test.com";
    private final User user = User.builder()
            .firstname("test")
            .lastname("user")
            .email(username)
            .role(Role.USER)
            .password("password")
            .build();


//    ### REMEMBER TO LOAD ENV VARIABLES ###
//    ### SECRET_KEY ###


    @Test
    void extractUsername() {
        String token = jwtService.generateToken(user);
        String extractedUsername = jwtService.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    void generateToken() {
        String token = jwtService.generateToken(user);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }


    @Test
    void isTokenValid() {
        User otherUser = User.builder()
                .firstname("other")
                .lastname("user")
                .email("otherUser@test.com")
                .password("password")
                .role(Role.USER)
                .build();
        String token = jwtService.generateToken(user);
        boolean isValid = jwtService.isTokenValid(token, otherUser);
        assertFalse(isValid);
    }
}