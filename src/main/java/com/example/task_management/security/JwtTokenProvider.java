package com.example.task_management.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    // Secret key for signing the JWT (should be securely managed)
    private final String SECRET_KEY = "3f2bb9dc71f44b97a3e8d347b891bb35"; // Replace with a more secure key in production
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    /**
     * Generates a JWT token for a given username.
     *
     * @param username The username for which the token is generated.
     * @return The generated JWT token.
     */
    public String generateToken(String username) {
        return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                   .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                   .compact();
    }

    /**
     * Extracts the username from a given JWT token.
     *
     * @param token The JWT token to parse.
     * @return The username contained in the token.
     */
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(SECRET_KEY)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }

    /**
     * Validates a given JWT token.
     * 
     * @param token The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     */
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                                .setSigningKey(SECRET_KEY)
                                .parseClaimsJws(token)
                                .getBody();
            // Check if the token has expired
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false; // Token is invalid
        }
    }
}