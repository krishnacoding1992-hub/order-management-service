package com.krishnacoding.oms.controller;

import com.krishnacoding.oms.dto.AuthResponse;
import com.krishnacoding.oms.dto.LoginRequest;
import com.krishnacoding.oms.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oms/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        authService.login(loginRequest);
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
