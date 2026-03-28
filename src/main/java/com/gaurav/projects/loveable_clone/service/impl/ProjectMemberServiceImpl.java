package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.member.InviteMemberRequest;
import com.gaurav.projects.loveable_clone.dto.member.MemberResponse;
import com.gaurav.projects.loveable_clone.dto.member.UpdateMemberRoleRequest;
import com.gaurav.projects.loveable_clone.entity.Project;
import com.gaurav.projects.loveable_clone.entity.ProjectMember;
import com.gaurav.projects.loveable_clone.entity.ProjectMemberId;
import com.gaurav.projects.loveable_clone.entity.User;
import com.gaurav.projects.loveable_clone.mapper.ProjectMemberMapper;
import com.gaurav.projects.loveable_clone.repository.ProjectMemberRepository;
import com.gaurav.projects.loveable_clone.repository.ProjectRepository;
import com.gaurav.projects.loveable_clone.repository.UserRepository;
import com.gaurav.projects.loveable_clone.security.AuthUtil;
import com.gaurav.projects.loveable_clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;


    @Override
    public List<MemberResponse> getProjectMembers(Long projectId) {
            Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();

    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {
        Long userId = authUtil.getCurrentUserId();
       Project project =getAccessibleProjectById(projectId, userId);

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Owner cannot be invited as member");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User is already a member of the project");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .role(request.role())
                .build();
        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);

    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project =getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId) {
        Long userId = authUtil.getCurrentUserId();
        Project project =getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User is not a member of the project");
        }
        projectMemberRepository.deleteById(projectMemberId);

    }

    private Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessbileProjectById(projectId,userId).orElseThrow();
    }
}
