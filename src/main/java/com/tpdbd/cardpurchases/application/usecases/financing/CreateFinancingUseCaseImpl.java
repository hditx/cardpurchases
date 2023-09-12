package com.tpdbd.cardpurchases.application.usecases.financing;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import com.tpdbd.cardpurchases.infrastructure.repositories.FinancingRepository;
import com.tpdbd.cardpurchases.domain.usecases.CreateFinancingUseCase;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
public class CreateFinancingUseCaseImpl implements CreateFinancingUseCase {
    private final FinancingRepository financingRepository;
    private final BankPort bankPort;

    @Override
    public void invoke(CreateFinancingCommand command) throws ParseException {
        var financing = parseToFinancing(command);
        financing.setBankId(bankPort.findById(command.getBankId()).get());
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
