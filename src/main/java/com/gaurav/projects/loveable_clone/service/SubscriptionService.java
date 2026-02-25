package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.subscription.CheckoutRequest;
import com.gaurav.projects.loveable_clone.dto.subscription.CheckoutResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.PortalResponse;
import com.gaurav.projects.loveable_clone.dto.subscription.SubscriptionResponse;


public interface SubscriptionService {

    SubscriptionResponse getUserSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest request);

    PortalResponse openCutomerPortal(Long userId);
}
