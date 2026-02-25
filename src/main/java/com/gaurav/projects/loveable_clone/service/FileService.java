package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.project.FileContentResponse;
import com.gaurav.projects.loveable_clone.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {

    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, Long userId, String path);
}
