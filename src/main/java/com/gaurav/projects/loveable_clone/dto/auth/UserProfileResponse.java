package com.gaurav.projects.loveable_clone.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
