package com.gaurav.projects.loveable_clone.controller;

import com.gaurav.projects.loveable_clone.dto.subscription.PlanLimitsResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.UsageTodayResponse;
import com.gaurav.projects.loveable_clone.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
public class UsageController {

    UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        Long userId = 1L; // In a real application, you would get this from the authenticated user context
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse> getPlanLimits() {
        Long userId = 1L; // In a real application, you would get this from the authenticated user context
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }


}
