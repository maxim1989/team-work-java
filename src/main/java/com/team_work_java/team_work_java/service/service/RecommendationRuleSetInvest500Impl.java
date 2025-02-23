package com.team_work_java.team_work_java.service.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;
import com.team_work_java.team_work_java.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RecommendationRuleSetInvest500Impl implements RecommendationRuleSet {
    final RecommendationsRepository recommendationsRepository;

    public RecommendationRuleSetInvest500Impl(RecommendationsRepository recommendationsRepository) {
        this.recommendationsRepository = recommendationsRepository;
    }

    @Override
    public Optional<RecommendationDto> getRecommendations(UUID id) {
        boolean result = recommendationsRepository.getRecommendationRuleSetInvest500Impl(id);
        if (result) {
            RecommendationDto recommendationDto = new RecommendationDto();
            recommendationDto.setId(UUID.fromString("147f6a0f-3b91-413b-ab99-87f081d60d5a"));
            recommendationDto.setName("Invest 500");
            recommendationDto.setText("Откройте свой путь к успеху с индивидуальным инвестиционным счетом (ИИС) от нашего банка! Воспользуйтесь налоговыми льготами и начните инвестировать с умом. Пополните счет до конца года и получите выгоду в виде вычета на взнос в следующем налоговом периоде. Не упустите возможность разнообразить свой портфель, снизить риски и следить за актуальными рыночными тенденциями. Откройте ИИС сегодня и станьте ближе к финансовой независимости!");
            return Optional.of(recommendationDto);
        }
        return Optional.empty();
    }
}
