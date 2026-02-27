package com.gaurav.projects.loveable_clone.entity;

import com.gaurav.projects.loveable_clone.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Plan plan;

    @Enumerated(EnumType.STRING)
    SubscriptionStatus status;
    String stripeSubscriptionId;
    String stripeCustomerId;
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd;
    Instant createdAt;
    Instant updatedAt;

}
