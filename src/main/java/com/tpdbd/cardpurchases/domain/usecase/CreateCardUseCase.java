package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.card.CreateCardCommand;

import java.text.ParseException;

public interface CreateCardUseCase {
    void invoke(CreateCardCommand command) throws ParseException;
}
