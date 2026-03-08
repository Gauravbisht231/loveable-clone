package com.gaurav.projects.loveable_clone.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @Email
        @NotBlank
        String email,

        @Size(min=4)
        String password,

        @Size(min=1, max=30)
        String name
) {
}
