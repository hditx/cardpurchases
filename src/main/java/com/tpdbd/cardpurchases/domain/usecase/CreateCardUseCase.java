package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.card.CreateCardCommand;

import java.text.ParseException;

public interface CreateCardUseCase {
    void invoke(CreateCardCommand command) throws ParseException;
}
