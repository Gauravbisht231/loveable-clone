package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.auth.AuthResponse;
import com.gaurav.projects.loveable_clone.dto.auth.LoginRequest;
import com.gaurav.projects.loveable_clone.dto.auth.SignupRequest;
import com.gaurav.projects.loveable_clone.service.IAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Override
    public AuthResponse signUp(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
