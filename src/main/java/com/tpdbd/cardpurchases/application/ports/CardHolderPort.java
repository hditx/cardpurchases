package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.CardHolder;

import java.util.Optional;

public interface CardHolderPort {
    CardHolder save(CardHolder cardHolder);

    Optional<CardHolder> findById(String id);
}
