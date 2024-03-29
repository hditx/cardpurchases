package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import com.tpdbd.cardpurchases.infrastructure.repositories.FinancingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FinancingPortImpl implements FinancingPort {

    private final FinancingRepository financingRepository;

    @Override
    public Financing save(Financing financing) {
        return financingRepository.save(financing);
    }

    @Override
    public Optional<Financing> findById(Long id) {
        return financingRepository.findById(id);
    }

    @Override
    public Optional<Financing> findByCode(String code) {
        return financingRepository.findByCode(code);
    }

    @Override
    public void delete(Financing financing) {
        financingRepository.delete(financing);
    }

    @Override
    public List<Financing> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate) {
        return financingRepository.findByStoreNameAndBetweenValidityStartDateAndValidityEndDate(filterStoreValidDate.store(),
                filterStoreValidDate.startDate(), filterStoreValidDate.endDate());
    }
}
