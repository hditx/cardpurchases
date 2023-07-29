package com.tpdbd.cardpurchases.application;

import com.tpdbd.cardpurchases.domain.Bank;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;

public class MostPaymentBank {
    private final BankRepository bankRepository;

    public MostPaymentBank(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank invoke() {
        return bankRepository.findById("1L").get();
    }
}
