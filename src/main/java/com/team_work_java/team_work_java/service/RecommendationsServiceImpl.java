package com.team_work_java.team_work_java.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;
import com.team_work_java.team_work_java.service.service.RecommendationRuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    private final Map<String, RecommendationRuleSet> recommendationRuleSetMap;

    @Autowired
    public RecommendationsServiceImpl(Map<String, RecommendationRuleSet> recommendationRuleSetMap) {
        this.recommendationRuleSetMap = recommendationRuleSetMap;
    }

    @Override
    public List<Optional<RecommendationDto>> getRecommendationsByUserId(UUID id) {
        final List<Optional<RecommendationDto>> recommendationDtoList = new ArrayList<>();

        recommendationRuleSetMap.forEach((k, v) -> {
            final Optional<RecommendationDto> recommendation =
                    recommendationRuleSetMap.get(k).getRecommendations(id);
            if (recommendation.isPresent()) {
                recommendationDtoList.add(recommendation);
            }
        });
        return recommendationDtoList;
    }
}
