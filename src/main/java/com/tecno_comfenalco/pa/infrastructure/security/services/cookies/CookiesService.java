package com.tecno_comfenalco.pa.infrastructure.security.services.cookies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tecno_comfenalco.pa.application.auth.dto.requests.LoginRequestDto;
import com.tecno_comfenalco.pa.shared.utils.jwt.JwtService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookiesService {

    @Value("${jwt.expiration-ms}")
    private Long expirationMs;

    private final JwtService jwtService;

    public CookiesService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public void sendCookie(HttpServletResponse response, LoginRequestDto request) {
        long defaultExpiration = 60 * 60 * 1000L; // 1 hora por defecto
        long configuredExpiration = expirationMs != null ? expirationMs.longValue() : defaultExpiration;
        long expirationTime = request.rememberMe() ? 7L * 24 * 60 * 60 * 1000 : configuredExpiration;

        String token = jwtService.encode(request.username(), expirationTime);

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setMaxAge((int) (expirationTime / 1000));
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
    }

    public void deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setMaxAge(0);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
    }
}
