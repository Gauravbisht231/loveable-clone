package com.gaurav.projects.loveable_clone.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {

   Long id;
   String email;
   String passwordHash;
   String name;
   String avatarUrl;
   Instant createdAt;
   Instant updatedAt;
   Instant deletedAt; //soft delete

}
