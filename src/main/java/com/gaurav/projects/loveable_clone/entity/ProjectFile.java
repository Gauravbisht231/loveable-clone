package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Project project;
    String path;
    String minioObjectKey;
    Instant createdAt;
    Instant updatedAt;

    @ManyToOne
    User createdBy;

    @ManyToOne
    User updatedBy;

}
