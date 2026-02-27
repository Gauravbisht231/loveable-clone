package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.project.ProjectRequest;
import com.gaurav.projects.loveable_clone.dto.project.ProjectResponse;
import com.gaurav.projects.loveable_clone.dto.project.ProjectSummaryResponse;
import com.gaurav.projects.loveable_clone.entity.Project;
import com.gaurav.projects.loveable_clone.entity.User;
import com.gaurav.projects.loveable_clone.mapper.ProjectMapper;
import com.gaurav.projects.loveable_clone.repository.ProjectRepository;
import com.gaurav.projects.loveable_clone.repository.UserRepository;
import com.gaurav.projects.loveable_clone.service.IProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectServiceImpl implements IProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getProjectById(Long id, Long userId) {



                return null;
    }

    @Override
    @Transactional
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void deleteProject(Long id, Long userId) {

    }
}
