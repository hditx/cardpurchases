package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Card;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CardPort {
    List<Card> findByExpirationDateLessThanEqual(Date expirationDate);
    Card save(Card card);
    Optional<Card> findById(Long id);

}
