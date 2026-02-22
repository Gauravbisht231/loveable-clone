package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProjectFile {
    Long id;
    @ManyToOne
    Project project;
    String path;
    String minioObjectKey;
    Instant createdAt;
    Instant updatedAt;
    User createdBy;
    User updatedBy;

}
