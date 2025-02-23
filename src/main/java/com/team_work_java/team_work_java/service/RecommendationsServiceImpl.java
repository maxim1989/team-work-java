package com.team_work_java.team_work_java.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    @Override
    public List<RecommendationDto> getRecommendationsByUserId(UUID id) {
        return List.of();
    }
}
