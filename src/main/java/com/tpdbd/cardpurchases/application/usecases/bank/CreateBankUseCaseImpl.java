package com.tpdbd.cardpurchases.application.usecases.bank;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.usecases.CreateBankUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
public class CreateBankUseCaseImpl implements CreateBankUseCase {
    private final BankPort bankPort;


    @Transactional
    @Override
    public void invoke(CreateBankCommand command) {
        var bank = parseToBank(command);
        bankPort.save(bank);
    }

    private Bank parseToBank(CreateBankCommand command) {
        return Bank
                .builder()
                .telephone(command.getTelephone())
                .cuit(command.getCuit())
                .name(command.getName())
                .address(command.getAddress())
                .build();
    }
}
