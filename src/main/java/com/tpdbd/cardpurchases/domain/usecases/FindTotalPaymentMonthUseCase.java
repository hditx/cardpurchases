package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.domain.entities.Payment;

import java.util.List;

public interface FindTotalPaymentMonthUseCase {
    List<Payment> invoke(String month);
}
