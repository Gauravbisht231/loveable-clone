package com.gaurav.projects.loveable_clone.dto.member;

import com.gaurav.projects.loveable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull
        ProjectRole role
) {
}
