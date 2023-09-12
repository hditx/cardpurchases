package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.MonthlyPaymentPort;
import com.tpdbd.cardpurchases.domain.entities.MonthlyPayments;
import com.tpdbd.cardpurchases.infrastructure.repositories.MonthlyPaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MonthlyPaymentPortImpl implements MonthlyPaymentPort {
    private final MonthlyPaymentsRepository monthlyPaymentsRepository;

    @Override
    public Optional<MonthlyPayments> findById(String id) {
        return monthlyPaymentsRepository.findById(id);
    }

    @Override
    public MonthlyPayments save(MonthlyPayments monthlyPayments) {
        return monthlyPaymentsRepository.save(monthlyPayments);
    }
}
