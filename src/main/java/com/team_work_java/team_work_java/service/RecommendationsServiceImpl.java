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
        final Optional<RecommendationDto> recommendationRuleSetInvest500Impl =
                recommendationRuleSetMap.get("recommendationRuleSetInvest500Impl").getRecommendations(id);

        if (recommendationRuleSetInvest500Impl.isPresent()) {
            recommendationDtoList.add(recommendationRuleSetInvest500Impl);
        }

        final Optional<RecommendationDto> recommendationRuleSetSimpleCreditImpl =
                recommendationRuleSetMap.get("recommendationRuleSetSimpleCreditImpl").getRecommendations(id);

        if (recommendationRuleSetSimpleCreditImpl.isPresent()) {
            recommendationDtoList.add(recommendationRuleSetSimpleCreditImpl);
        }

        final Optional<RecommendationDto> recommendationRuleSetTopSavingImpl =
                recommendationRuleSetMap.get("recommendationRuleSetTopSavingImpl").getRecommendations(id);

        if (recommendationRuleSetTopSavingImpl.isPresent()) {
            recommendationDtoList.add(recommendationRuleSetTopSavingImpl);
        }

        return recommendationDtoList;
    }
}
