package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.project.ProjectRequest;
import com.gaurav.projects.loveable_clone.dto.project.ProjectResponse;
import com.gaurav.projects.loveable_clone.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface IProjectService {

    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getProjectById(Long id );

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
