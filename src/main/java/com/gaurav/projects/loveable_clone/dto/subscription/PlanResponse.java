package com.gaurav.projects.loveable_clone.dto.subscription;

public record PlanResponse(
       Long id,
       String name,
       Integer maxProjects,
       Integer maxTokensPerDay,
       Integer unlimitedAI,
       String price
) {
}
