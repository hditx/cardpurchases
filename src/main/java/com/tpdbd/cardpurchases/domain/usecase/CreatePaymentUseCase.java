package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.usecases.payment.CreatePaymentCommand;

import java.text.ParseException;

public interface CreatePaymentUseCase {
    void invoke(CreatePaymentCommand command) throws ParseException;
}
