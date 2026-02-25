package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.member.InviteMemberRequest;
import com.gaurav.projects.loveable_clone.dto.member.MemberResponse;
import com.gaurav.projects.loveable_clone.dto.member.UpdateRoleRequest;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, Long userId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateRoleRequest request, Long userId);

    MemberResponse deleteMember(Long projectId, Long memberId, Long userId);
}
