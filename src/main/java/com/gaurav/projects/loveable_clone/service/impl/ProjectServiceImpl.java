package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.project.ProjectRequest;
import com.gaurav.projects.loveable_clone.dto.project.ProjectResponse;
import com.gaurav.projects.loveable_clone.dto.project.ProjectSummaryResponse;
import com.gaurav.projects.loveable_clone.entity.Project;
import com.gaurav.projects.loveable_clone.entity.ProjectMember;
import com.gaurav.projects.loveable_clone.entity.ProjectMemberId;
import com.gaurav.projects.loveable_clone.entity.User;
import com.gaurav.projects.loveable_clone.enums.ProjectRole;
import com.gaurav.projects.loveable_clone.error.ResourceNotFoundException;
import com.gaurav.projects.loveable_clone.mapper.ProjectMapper;
import com.gaurav.projects.loveable_clone.repository.ProjectMemberRepository;
import com.gaurav.projects.loveable_clone.repository.ProjectRepository;
import com.gaurav.projects.loveable_clone.repository.UserRepository;
import com.gaurav.projects.loveable_clone.service.IProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectServiceImpl implements IProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getProjectById(Long id, Long userId) {

        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);

    }

    @Override
    @Transactional
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user",userId.toString())
        );
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .role(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project = getAccessibleProjectById(id, userId);

        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setDeletedAt(Instant.now());
        projectRepository.delete(project);

    }


    private Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessbileProjectById(id, userId).orElseThrow(
                () -> new ResourceNotFoundException("Project", id.toString())
        );
    }
}
