package com.tpdbd.cardpurchases.application.usecases.card;

import com.tpdbd.cardpurchases.application.ports.CardPort;
import com.tpdbd.cardpurchases.domain.entities.Card;
import com.tpdbd.cardpurchases.domain.usecases.FindExpirationCardUseCase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class FindExpirationCardUseCaseImpl implements FindExpirationCardUseCase {

    private final CardPort cardPort;

    @Override
    public List<Card> invoke() {
        Date dateExpiration = java.sql.Date.valueOf(LocalDate.now().plusDays(30));
        return cardPort.findByExpirationDateLessThanEqual(dateExpiration);
    }
}
