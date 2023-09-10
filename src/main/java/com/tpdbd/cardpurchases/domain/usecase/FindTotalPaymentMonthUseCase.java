package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.domain.Payment;

import java.util.List;

public interface FindTotalPaymentMonthUseCase {
    List<Payment> invoke(String month);
}