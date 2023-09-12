package com.tpdbd.cardpurchases.application.usecases.bank;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.usecase.CreateBankUseCase;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateBankUseCaseImpl implements CreateBankUseCase {
    private final BankPort bankPort;


    public void invoke(CreateBankCommand command) {
        var bank = parseToBank(command);
        bankPort.save(bank);
    }

    private Bank parseToBank(CreateBankCommand command) {
        return Bank
                .builder()
                .telephone(command.telephone())
                .cuit(command.cuit())
                .name(command.name())
                .address(command.address())
                .build();
    }
}
