package com.tpdbd.cardpurchases.domain.usecase;

import com.tpdbd.cardpurchases.application.discount.CreateDiscountCommand;

import java.text.ParseException;

public interface CreateDiscountUseCase {
    void invoke(CreateDiscountCommand command) throws ParseException;
}
