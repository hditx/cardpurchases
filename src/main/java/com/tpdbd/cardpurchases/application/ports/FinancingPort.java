package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Financing;

import java.util.List;
import java.util.Optional;

public interface FinancingPort {
    Financing save(Financing financing);
    Optional<Financing> findById(Long id);

    Optional<Financing> findByCode(String code);

    void delete(Financing financing);

    List<Financing> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate);
}
