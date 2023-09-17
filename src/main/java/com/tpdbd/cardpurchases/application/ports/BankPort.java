package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Bank;

import java.util.Optional;

public interface BankPort {
    Bank save(Bank bank);
    Optional<Bank> findById(Long id);
}
