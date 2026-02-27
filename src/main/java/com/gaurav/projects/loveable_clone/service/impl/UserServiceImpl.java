package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.auth.UserProfileResponse;
import com.gaurav.projects.loveable_clone.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
