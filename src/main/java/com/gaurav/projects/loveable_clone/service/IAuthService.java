package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.auth.AuthResponse;
import com.gaurav.projects.loveable_clone.dto.auth.LoginRequest;
import com.gaurav.projects.loveable_clone.dto.auth.SignupRequest;

public interface IAuthService {
    AuthResponse signUp(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
