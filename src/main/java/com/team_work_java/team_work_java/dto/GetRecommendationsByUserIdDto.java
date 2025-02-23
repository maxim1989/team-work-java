package com.team_work_java.team_work_java.dto;

import java.util.List;
import java.util.UUID;

public class GetRecommendationsByUserIdDto {
    private UUID user_id;
    private List<RecommendationDto> recommendations;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public List<RecommendationDto> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<RecommendationDto> recommendations) {
        this.recommendations = recommendations;
    }
}
