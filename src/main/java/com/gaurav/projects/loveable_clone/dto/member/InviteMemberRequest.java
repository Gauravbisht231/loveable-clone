package com.gaurav.projects.loveable_clone.dto.member;

import com.gaurav.projects.loveable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
