package com.gaurav.projects.loveable_clone.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse userProfileResponse) {

}
