package com.tpdbd.cardpurchases.application.payment;

import com.tpdbd.cardpurchases.domain.Payment;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FindTotalPaymentMonth {
    private final PaymentRepository paymentRepository;

    public FindTotalPaymentMonth(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> invoke(String month) {
        return paymentRepository.findByMonth(month);
    }
}
