package com.tpdbd.cardpurchases.application.card;

import com.tpdbd.cardpurchases.domain.Card;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FindExpirationCard {
    private final CardRepository cardRepository;

    public FindExpirationCard(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public List<Card> invoke() {
        Date dateExpiration = java.sql.Date.valueOf(LocalDate.now().plusDays(30));
        return cardRepository.findByExpirationDateLessThanEqual(dateExpiration);
    }
}
