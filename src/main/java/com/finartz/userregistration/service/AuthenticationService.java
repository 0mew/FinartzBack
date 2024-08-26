package com.finartz.userregistration.service;

import com.finartz.userregistration.request.LoginRequest;
import com.finartz.userregistration.request.RegisterRequest;
import com.finartz.userregistration.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse register(RegisterRequest request);

    JwtAuthenticationResponse login(LoginRequest request);
}
