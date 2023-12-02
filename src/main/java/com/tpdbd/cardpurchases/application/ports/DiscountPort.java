package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountPort {
    Discount save(Discount discount);
    Optional<Discount> findById(String id);

    Optional<Discount> findByCode(String code);

    void delete(Discount discount);

    List<Discount> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate);
}
