package com.team_work_java.team_work_java.repository;

import com.team_work_java.team_work_java.dto.ProductTypeCountDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RecommendationsRepository {
    private final JdbcTemplate jdbcTemplate;

    public RecommendationsRepository(@Qualifier("recommendationsJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductTypeCountDto> getProductTypeAmountByUserId(UUID id) {
        return jdbcTemplate.query(
                "SELECT p.\"TYPE\" AS type, count(p.\"TYPE\") AS amount FROM transactions t INNER JOIN products p ON t.product_id = p.id WHERE t.user_id = ? GROUP BY p.\"TYPE\"",
                (resultSet, rowNum) -> {
                    ProductTypeCountDto p = new ProductTypeCountDto();
                    p.setAmount(resultSet.getInt("amount"));
                    p.setType(resultSet.getString("type"));
                    return p;
                },
                id
        );
    }

    public Integer getSumAmountByTypes(UUID id, String tType, String pType) {
        return jdbcTemplate.queryForObject(
                "SELECT sum(t.AMOUNT) FROM transactions t INNER JOIN products p ON t.product_id = p.id WHERE t.user_id = ? AND t.\"TYPE\" = ? AND p.\"TYPE\" = ?",
                Integer.class, id, tType, pType
        );
    }

    public Boolean getRecommendationRuleSetInvest500Impl(UUID id) {
        List<ProductTypeCountDto> productTypeCountDtoList = getProductTypeAmountByUserId(id);
        boolean oneDebit = false;
        boolean noInvest = true;
        for (ProductTypeCountDto productTypeCountDto : productTypeCountDtoList) {
            if (productTypeCountDto.getType().equals("DEBIT") && productTypeCountDto.getAmount() >= 1) {
                oneDebit = true;
            }

            if (productTypeCountDto.getType().equals("INVEST") && productTypeCountDto.getAmount() != 0) {
                noInvest = false;
            }
        }

        Integer sum = getSumAmountByTypes(id, "DEPOSIT", "SAVING");
        return oneDebit && noInvest && sum > 1000;
    }

    public Boolean getRecommendationRuleSetSimpleCreditImpl(UUID id) {
        List<ProductTypeCountDto> productTypeCountDtoList = getProductTypeAmountByUserId(id);
        boolean oneDebit = false;
        for (ProductTypeCountDto productTypeCountDto : productTypeCountDtoList) {
            if (productTypeCountDto.getType().equals("DEBIT") && productTypeCountDto.getAmount() >= 1) {
                oneDebit = true;
                break;
            }
        }

        Integer sumDebit = getSumAmountByTypes(id, "DEPOSIT", "DEBIT");
        Integer sumDebitWithdraw = getSumAmountByTypes(id, "WITHDRAW", "DEBIT");
        Integer sumSaving = getSumAmountByTypes(id, "DEPOSIT", "SAVING");
        return oneDebit && (sumDebit >= 50_000 || sumSaving >= 50_000) && sumDebit > sumDebitWithdraw;
    }

    public Boolean getRecommendationRuleSetTopSavingImpl(UUID id) {
        List<ProductTypeCountDto> productTypeCountDtoList = getProductTypeAmountByUserId(id);
        boolean noCredit = true;
        for (ProductTypeCountDto productTypeCountDto : productTypeCountDtoList) {
            if (productTypeCountDto.getType().equals("CREDIT") && productTypeCountDto.getAmount() != 0) {
                noCredit = false;
                break;
            }
        }

        Integer sumDebit = getSumAmountByTypes(id, "DEPOSIT", "DEBIT");
        Integer sumDebitWithdraw = getSumAmountByTypes(id, "WITHDRAW", "DEBIT");
        return noCredit && sumDebit > sumDebitWithdraw && sumDebitWithdraw > 100_000;
    }
}
