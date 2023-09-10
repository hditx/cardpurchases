package com.tpdbd.cardpurchases.application.card;

import com.tpdbd.cardpurchases.domain.Card;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.usecase.FindExpirationCardUseCase;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FindExpirationCardUseCaseImpl implements FindExpirationCardUseCase {
    private final CardRepository cardRepository;

    public FindExpirationCardUseCaseImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> invoke() {
        Date dateExpiration = java.sql.Date.valueOf(LocalDate.now().plusDays(30));
        return cardRepository.findByExpirationDateLessThanEqual(dateExpiration);
    }
}
