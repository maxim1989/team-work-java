package com.team_work_java.team_work_java.service.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;

import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet {
    public Optional<RecommendationDto> getRecommendations(UUID id);
}
