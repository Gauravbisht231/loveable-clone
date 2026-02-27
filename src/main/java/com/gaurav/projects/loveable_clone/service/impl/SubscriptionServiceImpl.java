package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.subscription.CheckoutRequest;
import com.gaurav.projects.loveable_clone.dto.subscription.CheckoutResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.PortalResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.SubscriptionResponse;
import com.gaurav.projects.loveable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getUserSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest request) {
        return null;
    }

    @Override
    public PortalResponse openCutomerPortal(Long userId) {
        return null;
    }
}
