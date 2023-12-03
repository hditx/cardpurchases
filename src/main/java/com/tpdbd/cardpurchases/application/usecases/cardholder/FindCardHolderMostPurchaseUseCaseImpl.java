package com.tpdbd.cardpurchases.application.usecases.cardholder;

import com.tpdbd.cardpurchases.application.ports.CardHolderPort;
import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import com.tpdbd.cardpurchases.domain.usecases.FindCardHolderMostPurchaseUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindCardHolderMostPurchaseUseCaseImpl implements FindCardHolderMostPurchaseUseCase {
    private final CardHolderPort cardHolderPort;
    @Override
    public List<CardHolder> invoke() {
        return cardHolderPort.findCardHolderMostPurchase();
    }
}
