package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.project.ProjectRequest;
import com.gaurav.projects.loveable_clone.dto.project.ProjectResponse;
import com.gaurav.projects.loveable_clone.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface IProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
