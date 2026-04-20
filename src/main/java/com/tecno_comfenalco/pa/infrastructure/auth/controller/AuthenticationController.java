package com.tecno_comfenalco.pa.infrastructure.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecno_comfenalco.pa.application.auth.command.actions.LoginUserCommand;
import com.tecno_comfenalco.pa.application.auth.command.response.LoginUserCommandResult;
import com.tecno_comfenalco.pa.application.auth.dto.requests.LoginRequestDto;
import com.tecno_comfenalco.pa.application.auth.dto.responses.LoginResponseDto;
import com.tecno_comfenalco.pa.application.auth.usecases.AuthenticationUseCase;
import com.tecno_comfenalco.pa.infrastructure.security.services.cookies.CookiesService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/auth")
@PreAuthorize("permitAll()")
public class AuthenticationController {

    private final AuthenticationUseCase authenticationUseCase;
    private final CookiesService cookiesService;

    public AuthenticationController(AuthenticationUseCase authenticationUseCase, CookiesService cookiesService) {
        this.authenticationUseCase = authenticationUseCase;
        this.cookiesService = cookiesService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request, HttpServletResponse response) {
        LoginUserCommand cmd = new LoginUserCommand(request.username(), request.password(), request.rememberMe());
        LoginUserCommandResult result = authenticationUseCase.loginUser(cmd);

        cookiesService.sendCookie(response, request);

        return ResponseEntity.ok(new LoginResponseDto("Usuario exitosamente autenticado", result.role()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletResponse response) {
        cookiesService.deleteCookie(response);
        return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
    }

    @GetMapping("/test")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello " + SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, Boolean>> authenticate() {
        return ResponseEntity.ok().body(Map.of("authenticated", true));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public ResponseEntity<Map<String, String>> me(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok().body(Map.of("username", user.getUsername()));
    }
}
