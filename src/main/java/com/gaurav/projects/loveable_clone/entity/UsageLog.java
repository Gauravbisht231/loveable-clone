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
public class UsageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Project project;
    String action; // e.g., "generate_code", "preview", etc.
    Integer tokensUsed;
    Integer durationMs;
    String metadata; // JSON string for{model used, prompt used}
    Instant createdAt;

}
