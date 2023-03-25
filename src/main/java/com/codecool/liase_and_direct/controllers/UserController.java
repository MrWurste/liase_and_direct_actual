package com.codecool.liase_and_direct.controllers;

import com.codecool.liase_and_direct.models.users.UserResponse;
import com.codecool.liase_and_direct.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codecool.liase_and_direct.user.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<UserResponse> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        UserResponse userResponse = new UserResponse();
        Optional<User> me = userRepository.findByEmail(currentEmail);
        me.ifPresent(I -> {
            userResponse.setFirstname(I.getFirstname());
            userResponse.setLastname(I.getLastname());
            userResponse.setEmail(I.getEmail());
            userResponse.setRole(I.getRole());
        });
        System.out.println(userResponse);
        return ResponseEntity.ok(userResponse);
    }
}
