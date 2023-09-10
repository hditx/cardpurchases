package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.purchase.CreatePurchaseCommand;

public interface CreateMonthlyPurchaseUseCase {
    void invoke(CreatePurchaseCommand command);
}
