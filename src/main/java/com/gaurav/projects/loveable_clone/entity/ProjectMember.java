package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.ProjectRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProjectMember {

    ProjectMemberId id;
    Project project;
    User user;
    ProjectRole role;

    Instant createdAt;
    Instant acceptedAt;
}
