package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProjectMemberId {
    Long projectId;
    Long userId;
}
