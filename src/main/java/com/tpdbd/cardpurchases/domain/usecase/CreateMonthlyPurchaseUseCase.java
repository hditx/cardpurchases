package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.purchase.CreatePurchaseCommand;

public interface CreateMonthlyPurchaseUseCase {
    void invoke(CreatePurchaseCommand command);
}
