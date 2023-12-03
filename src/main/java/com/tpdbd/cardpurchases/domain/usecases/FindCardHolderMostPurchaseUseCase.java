package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.domain.entities.CardHolder;

import java.util.List;

public interface FindCardHolderMostPurchaseUseCase {
    List<CardHolder> invoke();
}
