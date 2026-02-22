package com.gaurav.projects.loveable_clone.controller;

import com.gaurav.projects.loveable_clone.dto.project.ProjectRequest;
import com.gaurav.projects.loveable_clone.dto.project.ProjectResponse;
import com.gaurav.projects.loveable_clone.dto.project.ProjectSummaryResponse;
import com.gaurav.projects.loveable_clone.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private  final IProjectService projectService;

    @GetMapping("")
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects(){
        Long userId = 1L; // TODO: Get from auth context
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId = 1L; // TODO: Get from auth context
        return ResponseEntity.ok(projectService.getProjectById(id, userId));

    }

    @PostMapping("")
    public ResponseEntity<ProjectResponse> createProject (@RequestBody ProjectRequest request){
        Long userId = 1L; // TODO: Get from auth context
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request, userId));

    }

}
