package com.gaurav.projects.loveable_clone.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
