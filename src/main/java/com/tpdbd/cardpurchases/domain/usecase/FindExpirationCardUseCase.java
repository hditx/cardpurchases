package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.domain.Card;

import java.util.List;

public interface FindExpirationCardUseCase {
    List<Card> invoke();
}
