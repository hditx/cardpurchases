package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.infrastructure.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class DiscountPortImpl implements DiscountPort {

    private final DiscountRepository discountRepository;

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public Optional<Discount> findByCode(String code) {
        return discountRepository.findByCode(code);
    }

    @Override
    public void delete(Discount discount) {
        discountRepository.delete(discount);
    }

    @Override
    public List<Discount> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate) {
        return discountRepository.findByStoreNameAndBetweenValidityStartDateAndValidityEndDate(filterStoreValidDate.store(),
                filterStoreValidDate.startDate(), filterStoreValidDate.endDate());
    }
}
