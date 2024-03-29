package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.application.usecases.financing.CreateFinancingCommand;

import java.text.ParseException;

public interface CreateFinancingUseCase {
    void invoke(CreateFinancingCommand command) throws ParseException;
}
