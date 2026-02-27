package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
   String email;
   String passwordHash;
   String name;
   String avatarUrl;

   @CreationTimestamp
   Instant createdAt;

   @UpdateTimestamp
   Instant updatedAt;

   Instant deletedAt; //soft delete

}
