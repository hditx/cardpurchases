package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.domain.entities.Bank;

public interface MostPaymentBankUseCase {
    Bank invoke();
}
