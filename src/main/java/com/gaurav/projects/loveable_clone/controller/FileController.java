package com.gaurav.projects.loveable_clone.controller;

import com.gaurav.projects.loveable_clone.dto.project.FileContentResponse;
import com.gaurav.projects.loveable_clone.dto.project.FileNode;
import com.gaurav.projects.loveable_clone.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getProjectFiles(@PathVariable Long projectId) {
        Long userId = 1L; // TODO: Get from auth context
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ) {
        Long userId = 1L; // TODO: Get from auth context
        return ResponseEntity.ok(fileService.getFileContent(projectId, userId, path));
    }
}
