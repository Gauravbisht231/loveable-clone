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


    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
//        List<MemberResponse> memberResponseList = new ArrayList<>();
//        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));
//
//        memberResponseList.addAll(
//                projectMemberRepository.findByIdProjectId(projectId)
//                        .stream()
//                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
//                        .toList()
//        );
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();

    }

    private Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessbileProjectById(projectId,userId).orElseThrow();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, Long userId, InviteMemberRequest request) {
       Project project =getAccessibleProjectById(projectId, userId);
       if(!userId.equals(project.getOwner().getId())){
           throw new RuntimeException("Only project owner can invite members");
       }
        User invitee = userRepository.findByEmail(request.email()).orElseThrow();
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
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        Project project =getAccessibleProjectById(projectId, userId);
        if(!userId.equals(project.getOwner().getId())){
            throw new RuntimeException("Only project owner can invite members");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project =getAccessibleProjectById(projectId, userId);
        if(!userId.equals(project.getOwner().getId())){
            throw new RuntimeException("Only project owner can invite members");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User is not a member of the project");
        }
        projectMemberRepository.deleteById(projectMemberId);

    }
}
