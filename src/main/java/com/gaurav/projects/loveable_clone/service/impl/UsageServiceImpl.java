package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.subscription.PlanLimitsResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.UsageTodayResponse;
import com.gaurav.projects.loveable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
