package com.gaurav.projects.loveable_clone.controller;


import com.gaurav.projects.loveable_clone.dto.subscription.*;
import com.gaurav.projects.loveable_clone.service.PlanService;
import com.gaurav.projects.loveable_clone.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BllingController {

    private final SubscriptionService subscriptionService;
    private final PlanService planService;


    @GetMapping("api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getUserSubscription(userId));
    }

    @PostMapping("api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
            @RequestBody CheckoutRequest request
    ) {
        Long userId = 1L;
        // This is a placeholder. In a real application, you would create a Stripe checkout session here.
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(userId, request));
    }
    @PostMapping("api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        Long userId = 1L;
        // This is a placeholder. In a real application, you would create a Stripe customer portal session here.
        return ResponseEntity.ok(subscriptionService.openCutomerPortal(userId));
    }

}
