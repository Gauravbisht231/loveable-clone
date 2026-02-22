package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Project {
    Long id;
    String name;
    User owner;
    Boolean isPublic;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt; //soft delete

}
