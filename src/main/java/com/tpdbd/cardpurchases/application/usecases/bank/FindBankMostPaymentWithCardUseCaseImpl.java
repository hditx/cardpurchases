package com.tpdbd.cardpurchases.application.usecases.bank;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.usecases.FindBankMostPaymentWithCardUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindBankMostPaymentWithCardUseCaseImpl implements FindBankMostPaymentWithCardUseCase {
    private final BankPort bankPort;

    @Override
    public Bank invoke() {
        return bankPort.findMostPaymentWithCard();
    }
}
