package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.CashPaymentPort;
import com.tpdbd.cardpurchases.domain.entities.CashPayment;
import com.tpdbd.cardpurchases.infrastructure.repositories.CashPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CashPaymentPortImpl implements CashPaymentPort {

    private final CashPaymentRepository cashPaymentRepository;


    @Override
    public CashPayment save(CashPayment cashPayment) {
        return cashPaymentRepository.save(cashPayment);
    }
}
