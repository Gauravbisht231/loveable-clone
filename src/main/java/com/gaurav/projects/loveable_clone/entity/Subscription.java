package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.SubscriptionStatus;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
    Long id;
//    @ManyToOne //subscription belongs to one user
    User user;
    Plan plan;
    SubscriptionStatus status;
    String stripeSubscriptionId;
    String stripeCustomerId;
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd;
    Instant createdAt;
    Instant updatedAt;

}
