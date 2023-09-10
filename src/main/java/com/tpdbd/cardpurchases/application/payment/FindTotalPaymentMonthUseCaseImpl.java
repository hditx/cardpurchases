package com.tpdbd.cardpurchases.application.payment;

import com.tpdbd.cardpurchases.domain.Payment;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.usecase.FindTotalPaymentMonthUseCase;

import java.util.List;

public class FindTotalPaymentMonthUseCaseImpl implements FindTotalPaymentMonthUseCase {
    private final PaymentRepository paymentRepository;

    public FindTotalPaymentMonthUseCaseImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> invoke(String month) {
        return paymentRepository.findByMonth(month);
    }
}
