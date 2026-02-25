package com.gaurav.projects.loveable_clone.dto.subscription;

public record PlanLimitsResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        Boolean unlimitedAi
) {
}
