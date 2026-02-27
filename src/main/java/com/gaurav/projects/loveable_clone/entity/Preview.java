package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.PreviewStatus;
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
public class Preview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Project project;

    String namespace;
    String podName;
    String previewUrl;

    @Enumerated(EnumType.STRING)
    PreviewStatus status;
    Instant createdAt;
    Instant updatedAt;
    Instant terminatedAt;

}
