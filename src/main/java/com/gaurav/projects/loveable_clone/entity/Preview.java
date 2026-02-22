package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.PreviewStatus;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Preview {
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant createdAt;
    Instant updatedAt;
    Instant terminatedAt;

}
