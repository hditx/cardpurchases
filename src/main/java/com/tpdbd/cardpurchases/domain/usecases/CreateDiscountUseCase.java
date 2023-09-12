package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.application.usecases.discount.CreateDiscountCommand;

import java.text.ParseException;

public interface CreateDiscountUseCase {
    void invoke(CreateDiscountCommand command) throws ParseException;
}
