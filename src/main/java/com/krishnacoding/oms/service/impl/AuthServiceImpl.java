package com.krishnacoding.oms.service.impl;

import com.krishnacoding.oms.dto.AuthResponse;
import com.krishnacoding.oms.dto.LoginRequest;
import com.krishnacoding.oms.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        AuthResponse response = new AuthResponse();
        response.setUsername(authentication.getName());
        response.setMessage("Login successful");
        return response;
    }
}
