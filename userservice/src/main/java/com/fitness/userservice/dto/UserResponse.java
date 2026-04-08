package com.fitness.userservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class UserResponse {
     private UUID id;

    private String email;

    private String password;
    private String firstName;
    private String lastName;
      private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
