package com.team_work_java.team_work_java.service.service;

import com.team_work_java.team_work_java.dto.RecommendationDto;
import com.team_work_java.team_work_java.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RecommendationRuleSetTopSavingImpl implements RecommendationRuleSet {
    final RecommendationsRepository recommendationsRepository;

    public RecommendationRuleSetTopSavingImpl(RecommendationsRepository recommendationsRepository) {
        this.recommendationsRepository = recommendationsRepository;
    }

    @Override
    public Optional<RecommendationDto> getRecommendations(UUID id) {
        boolean result = recommendationsRepository.getRecommendationRuleSetTopSavingImpl(id);
        if (result) {
            RecommendationDto recommendationDto = new RecommendationDto();
            recommendationDto.setId(UUID.fromString("ab138afb-f3ba-4a93-b74f-0fcee86d447f"));
            recommendationDto.setName("Простой кредит");
            recommendationDto.setText("Откройте мир выгодных кредитов с нами! Ищете способ быстро и без лишних хлопот получить нужную сумму? Тогда наш выгодный кредит — именно то, что вам нужно! Мы предлагаем низкие процентные ставки, гибкие условия и индивидуальный подход к каждому клиенту. Почему выбирают нас: Быстрое рассмотрение заявки. Мы ценим ваше время, поэтому процесс рассмотрения заявки занимает всего несколько часов. Удобное оформление. Подать заявку на кредит можно онлайн на нашем сайте или в мобильном приложении. Широкий выбор кредитных продуктов. Мы предлагаем кредиты на различные цели: покупку недвижимости, автомобиля, образование, лечение и многое другое. Не упустите возможность воспользоваться выгодными условиями кредитования от нашей компании!");
            return Optional.of(recommendationDto);
        }
        return Optional.empty();
    }
}
