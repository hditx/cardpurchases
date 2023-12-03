package com.tpdbd.cardpurchases.application.usecases.financing;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import com.tpdbd.cardpurchases.domain.usecases.CreateFinancingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
public class CreateFinancingUseCaseImpl implements CreateFinancingUseCase {
    private final FinancingPort financingPort;
    private final BankPort bankPort;

    @Transactional
    @Override
    public void invoke(CreateFinancingCommand command) throws ParseException {
        var financing = parseToFinancing(command);
        financing.setBankId(bankPort.findById(command.getBankId()).get());
        financingPort.save(financing);
    }

    private Financing parseToFinancing(CreateFinancingCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return Financing.builder()
                .code(command.getCode())
                .nameStore(command.getNameStore())
                .interest(command.getInteres())
                .numberOfQuotas(command.getNumberOfQuotas())
                .comments(command.getComments())
                .promotionTitle(command.getPromotionTitle())
                .cuitStore(command.getCuitStore())
                .validityEndDate(formatter.parse(command.getValidityEndDate()))
                .validityStartDate(formatter.parse(command.getValidityStartDate()))
                .build();
    }
}
