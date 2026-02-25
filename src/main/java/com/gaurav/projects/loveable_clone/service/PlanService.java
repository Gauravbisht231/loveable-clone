package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
