package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.purchase.UpdatePurchaseDateCommand;

import java.text.ParseException;

public interface UpdatePurchaseDateUseCase {
    void invoke(UpdatePurchaseDateCommand command) throws ParseException;
}
