package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.infrastructure.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
    public Optional<Discount> findById(String id) {
        return discountRepository.findById(id);
    }
}
