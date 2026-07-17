package com.krishnacoding.oms.service;

import com.krishnacoding.oms.dto.AuthResponse;
import com.krishnacoding.oms.dto.LoginRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);
}
