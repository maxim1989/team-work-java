package com.team_work_java.team_work_java.service.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;
import com.team_work_java.team_work_java.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RecommendationRuleSetSimpleCreditImpl implements RecommendationRuleSet {
    final RecommendationsRepository recommendationsRepository;

    public RecommendationRuleSetSimpleCreditImpl(RecommendationsRepository recommendationsRepository) {
        this.recommendationsRepository = recommendationsRepository;
    }

    @Override
    public Optional<RecommendationDto> getRecommendations(UUID id) {
        boolean result = recommendationsRepository.getRecommendationRuleSetSimpleCreditImpl(id);
        if (result) {
            RecommendationDto recommendationDto = new RecommendationDto();
            recommendationDto.setId(UUID.fromString("59efc529-2fff-41af-baff-90ccd7402925"));
            recommendationDto.setName("Top Saving");
            recommendationDto.setText("Откройте свою собственную «Копилку» с нашим банком! «Копилка» — это уникальный банковский инструмент, который поможет вам легко и удобно накапливать деньги на важные цели. Больше никаких забытых чеков и потерянных квитанций — всё под контролем! Преимущества «Копилки»: Накопление средств на конкретные цели. Установите лимит и срок накопления, и банк будет автоматически переводить определенную сумму на ваш счет. Прозрачность и контроль. Отслеживайте свои доходы и расходы, контролируйте процесс накопления и корректируйте стратегию при необходимости. Безопасность и надежность. Ваши средства находятся под защитой банка, а доступ к ним возможен только через мобильное приложение или интернет-банкинг. Начните использовать «Копилку» уже сегодня и станьте ближе к своим финансовым целям!");
            return Optional.of(recommendationDto);
        }
        return Optional.empty();
    }
}
