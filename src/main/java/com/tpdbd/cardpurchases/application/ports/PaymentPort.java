package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Payment;

import java.util.List;

public interface PaymentPort {
    Payment findByCode(String code);
    List<Payment> findByMonth(String month);

    Payment save(Payment payment);
}
