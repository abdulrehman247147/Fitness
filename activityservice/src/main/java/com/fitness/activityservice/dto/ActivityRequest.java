package com.fitness.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.activityservice.model.ActivityType;

import lombok.Data;

@Data
public class ActivityRequest {
    private String userId;
    private ActivityType type; // e.g., "RUNNING", "CYCLING", etc.
    private Integer duration; // in minutes
    private Integer caloriesBurned; // optional, can be calculated based on type and duration   
    private LocalDateTime startTime; // when the activity started
    private Map<String, Object> additionalMetrics; // e.g., distance, steps, etc.

    // Additional metrics can be added as needed, e.g., distance, steps, etc.

}
