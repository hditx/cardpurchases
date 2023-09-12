package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.domain.entities.Bank;

public interface MostPaymentBankUseCase {
    Bank invoke();
}
