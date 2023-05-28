package com.tpdbd.cardpurchases.application.financing;

import com.tpdbd.cardpurchases.domain.Financing;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.FinancingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateFinancing {
    private final FinancingRepository financingRepository;
    private final BankRepository bankRepository;

    public CreateFinancing(FinancingRepository financingRepository, BankRepository bankRepository) {
        this.financingRepository = financingRepository;
        this.bankRepository = bankRepository;
    }

    public void invoke(CreateFinancingCommand command) throws ParseException {
        var financing = parseToFinancing(command);
        financing.setBankId(bankRepository.findById(command.getBankId()).get());
        financingRepository.save(financing);
    }

    private Financing parseToFinancing(CreateFinancingCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return Financing.builder()
                .code(command.getCode())
                .nameStore(command.getNameStore())
                .interes(command.getInteres())
                .numberOfQuotas(command.getNumberOfQuotas())
                .comments(command.getComments())
                .promotionTitle(command.getPromotionTitle())
                .cuitStore(command.getCuitStore())
                .validityEndDate(formatter.parse(command.getValidityEndDate()))
                .validityStartDate(formatter.parse(command.getValidityStartDate()))
                .build();
    }
}
