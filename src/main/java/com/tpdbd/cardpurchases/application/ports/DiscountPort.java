package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Discount;

import java.util.Optional;

public interface DiscountPort {
    Discount save(Discount discount);
    Optional<Discount> findById(Long id);
}
