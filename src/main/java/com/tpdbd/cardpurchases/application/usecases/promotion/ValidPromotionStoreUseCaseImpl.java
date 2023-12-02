package com.tpdbd.cardpurchases.application.usecases.promotion;

import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.domain.entities.Promotion;
import com.tpdbd.cardpurchases.domain.usecases.ValidPromotionStoreUseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ValidPromotionStoreUseCaseImpl implements ValidPromotionStoreUseCase {

    private final DiscountPort discountPort;
    private final FinancingPort financingPort;

    @Override
    public List<Promotion> invoke(FilterStoreValidDateCommand filterStoreValidDate) {
        List<Promotion> promotions = new ArrayList<>();
        var discounts = discountPort.findByStoreNameAndBetweenStartDateAndEndDate(filterStoreValidDate);
        var finangcins = financingPort.findByStoreNameAndBetweenStartDateAndEndDate(filterStoreValidDate);
        promotions.addAll(finangcins);
        promotions.addAll(discounts);
        return promotions;
    }
}
