package com.tpdbd.cardpurchases.application.bank;

import com.tpdbd.cardpurchases.domain.*;
import com.tpdbd.cardpurchases.domain.repository.*;


public class CreateBank {
    private final BankRepository bankRepository;

    public CreateBank(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void invoke(CreateBankCommand command) {
        var bank = parseToBank(command);
        bankRepository.save(bank);
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
