package com.team_work_java.team_work_java.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecommendationsService {
    public List<Optional<RecommendationDto>> getRecommendationsByUserId(UUID id);
}
