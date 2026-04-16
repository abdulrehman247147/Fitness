package com.fitness.activityservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UservalidationService {

    private final WebClient userServiceWebClient;

    public Boolean validateUser(String userId) {

        try {
               return userServiceWebClient.get()
                .uri("/api/users/{userId}/validate", userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        } catch (WebClientResponseException e) {
           if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
             throw new RuntimeException("User not found with id: " + userId);
           } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
             throw new RuntimeException("Invalid user ID: " + userId);
           } else {
             throw new RuntimeException("Error validating user with id: " + userId, e);
           }
        }
        

    
    }
    
}
