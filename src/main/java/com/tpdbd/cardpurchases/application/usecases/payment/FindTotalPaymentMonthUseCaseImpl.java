package com.tpdbd.cardpurchases.application.usecases.payment;

import com.tpdbd.cardpurchases.application.ports.PaymentPort;
import com.tpdbd.cardpurchases.domain.entities.Payment;
import com.tpdbd.cardpurchases.domain.usecases.FindTotalPaymentMonthUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindTotalPaymentMonthUseCaseImpl implements FindTotalPaymentMonthUseCase {
    private final PaymentPort paymentPort;

    @Override
    public List<Payment> invoke(String month) {
        return paymentPort.findByMonth(month);
    }
}
