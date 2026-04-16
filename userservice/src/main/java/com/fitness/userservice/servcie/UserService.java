package com.fitness.userservice.servcie;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.userservice.dto.ResgiterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRespository Respository;

    public UserResponse register(ResgiterRequest request) {

        if ((Respository.existsByEmail(request.getEmail()))) {
            throw new RuntimeException("Email already exists");
            }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedsUser = Respository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedsUser.getId());
        userResponse.setEmail(savedsUser.getEmail());
        userResponse.setPassword(savedsUser.getPassword());
        userResponse.setFirstName(savedsUser.getFirstName());
        userResponse.setLastName(savedsUser.getLastName());
        userResponse.setCreatedAt(savedsUser.getCreatedAt());
        userResponse.setUpdatedAt(savedsUser.getUpdatedAt());
        return userResponse;
    }

    public UserResponse getUserProfile(UUID userId) {
        User user = Respository.findById(userId).orElseThrow(() 
                -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }

    public Boolean existByUserId(UUID userId) {
        log.info("Validating user with id: {}", userId);
        return Respository.existsById(userId);
    }
    
}
