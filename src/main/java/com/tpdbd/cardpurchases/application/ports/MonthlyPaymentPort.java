package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.MonthlyPayments;

import java.util.Optional;

public interface MonthlyPaymentPort {
    Optional<MonthlyPayments> findById(Long id);
    MonthlyPayments save(MonthlyPayments monthlyPayments);
}
