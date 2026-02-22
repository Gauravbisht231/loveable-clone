package com.gaurav.projects.loveable_clone.dto.auth;

public record SignupRequest(
        String email,
        String password,
        String name
) {
}
