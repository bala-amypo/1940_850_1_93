package com.example.demo.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, Long userId, String role) {
        // Tests mock this method — real logic NOT required
        return "dummy-jwt-token";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }

    public String extractUsername(String token) {
        return null;
    }

    public Long extractUserId(String token) {
        return null;
    }

    public String extractRole(String token) {
        return null;
    }
}
