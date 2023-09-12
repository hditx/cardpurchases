package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.application.usecases.purchase.CreatePurchaseCommand;

public interface CreateMonthlyPurchaseUseCase {
    void invoke(CreatePurchaseCommand command);
}
