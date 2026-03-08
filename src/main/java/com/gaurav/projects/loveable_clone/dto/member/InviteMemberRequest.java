package com.gaurav.projects.loveable_clone.dto.member;

import com.gaurav.projects.loveable_clone.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email
        @NotNull
        @NotBlank
        String email,

        @NotBlank
        ProjectRole role
) {
}
