package com.team_work_java.team_work_java.controller;

import com.team_work_java.team_work_java.dto.GetRecommendationsByUserIdDto;
import com.team_work_java.team_work_java.dto.RecommendationDto;
import com.team_work_java.team_work_java.service.RecommendationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("recommendation")
public class RecommendationsController {
    private final RecommendationsService recommendationsService;

    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @GetMapping("{id}")
    public ResponseEntity<GetRecommendationsByUserIdDto> getRecommendationsByUserId(@PathVariable UUID id) {
        final GetRecommendationsByUserIdDto getRecommendationsByUserIdDto = new GetRecommendationsByUserIdDto();
        final List<Optional<RecommendationDto>> recommendationDtoList = recommendationsService.getRecommendationsByUserId(id);

        getRecommendationsByUserIdDto.setUser_id(id);
        getRecommendationsByUserIdDto.setRecommendations(recommendationDtoList);

        return ResponseEntity.ok(getRecommendationsByUserIdDto);
    }
}
