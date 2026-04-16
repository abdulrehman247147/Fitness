package com.fitness.userservice.controller;

import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.userservice.dto.ResgiterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.servcie.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {


    private UserService userSerive;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable UUID userId){
        return ResponseEntity.ok(userSerive.getUserProfile(userId));
    }

     @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody ResgiterRequest request){
        return ResponseEntity.ok(userSerive.register(request));
    }

     @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable UUID userId){
        return ResponseEntity.ok(userSerive.existByUserId(userId));
    }

    
}
