package com.gaurav.projects.loveable_clone.service;

import com.gaurav.projects.loveable_clone.dto.auth.UserProfileResponse;

public interface IUserService {

    UserProfileResponse getProfile(Long userId);
}
