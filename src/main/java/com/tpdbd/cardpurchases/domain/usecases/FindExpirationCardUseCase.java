package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.domain.entities.Card;

import java.util.List;

public interface FindExpirationCardUseCase {
    List<Card> invoke();
}
