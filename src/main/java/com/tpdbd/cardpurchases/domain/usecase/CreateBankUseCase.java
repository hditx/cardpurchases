package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.bank.CreateBankCommand;

public interface CreateBankUseCase {
    void invoke(CreateBankCommand command);
}
