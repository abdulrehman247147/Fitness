package com.fitness.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fitness.activityservice.model.ActivityType;

import lombok.Data;


@Data
public class ActivityResponse {
    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration; // in minutes
    private Integer caloriesBurned; 
    private LocalDateTime startTime;

    @Field("additional_metrics")
    private Map<String, Object> additionalMetrics; // e.g., distance, steps, etc.
    
  
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}
