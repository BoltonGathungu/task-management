package com.example.task_management.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Custom AuthenticationEntryPoint that handles unauthorized access to resources.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * This method is called when an AuthenticationException is thrown.
     * It sends an HTTP 401 Unauthorized response to the client.
     *
     * @param request       The HttpServletRequest object.
     * @param response      The HttpServletResponse object.
     * @param authException The exception that triggered the entry point.
     * @throws IOException If an input or output exception occurs.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, 
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}