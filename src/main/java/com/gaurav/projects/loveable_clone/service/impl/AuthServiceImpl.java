package com.gaurav.projects.loveable_clone.service.impl;

import com.gaurav.projects.loveable_clone.dto.auth.AuthResponse;
import com.gaurav.projects.loveable_clone.dto.auth.LoginRequest;
import com.gaurav.projects.loveable_clone.dto.auth.SignupRequest;
import com.gaurav.projects.loveable_clone.entity.User;
import com.gaurav.projects.loveable_clone.error.BadRequestException;
import com.gaurav.projects.loveable_clone.mapper.UserMapper;
import com.gaurav.projects.loveable_clone.repository.UserRepository;
import com.gaurav.projects.loveable_clone.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level= lombok.AccessLevel.PRIVATE)
public class AuthServiceImpl implements IAuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;


    @Override
    public AuthResponse signUp(SignupRequest request) {
        // if already exists, ask him to login, not signup again
       userRepository.findByUsername(request.username()).ifPresent(user ->{
            throw new BadRequestException("Username already exists " + request.username());
       });

       //else create a new user and save it to the database
       User user = userMapper.toEntity(request);
       user.setPassword(passwordEncoder.encode(request.password()));
       userRepository.save(user);

       return new AuthResponse("dymmy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
