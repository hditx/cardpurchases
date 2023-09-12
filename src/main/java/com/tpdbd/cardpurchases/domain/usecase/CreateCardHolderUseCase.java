package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.cardholder.CreateCardHolderCommand;

import java.text.ParseException;

public interface CreateCardHolderUseCase {
    void invoke(CreateCardHolderCommand command) throws ParseException;
}
