package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.application.usecases.bank.CreateBankCommand;

public interface CreateBankUseCase {
    void invoke(CreateBankCommand command);
}
