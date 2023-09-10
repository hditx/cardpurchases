package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.purchase.UpdatePurchaseDateCommand;

import java.text.ParseException;

public interface UpdatePurchaseDateUseCase {
    void invoke(UpdatePurchaseDateCommand command) throws ParseException;
}
