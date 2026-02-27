package com.gaurav.projects.loveable_clone.controller;


import com.gaurav.projects.loveable_clone.dto.auth.AuthResponse;
import com.gaurav.projects.loveable_clone.dto.auth.LoginRequest;
import com.gaurav.projects.loveable_clone.dto.auth.SignupRequest;
import com.gaurav.projects.loveable_clone.dto.auth.UserProfileResponse;
import com.gaurav.projects.loveable_clone.service.IAuthService;
import com.gaurav.projects.loveable_clone.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    IAuthService authService;
    IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest request){

        AuthResponse response = authService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
      AuthResponse response = authService.login(request);
      return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
