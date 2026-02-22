package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UsageLog {
    Long id;
    User user;
    Project project;
    String action; // e.g., "generate_code", "preview", etc.
    Integer tokensUsed;
    Integer durationMs;
    String metadata; // JSON string for{model used, prompt used}
    Instant createdAt;

}
