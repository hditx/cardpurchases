package com.tpdbd.cardpurchases.application.usecases.bank;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.usecase.MostPaymentBankUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MostPaymentBankUseCaseImpl implements MostPaymentBankUseCase {
    private final BankPort bankPort;


    @Override
    public Bank invoke() {
        return bankPort.findById("1L").get();
    }
}
