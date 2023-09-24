package com.tpdbd.cardpurchases.application.usecases.cardholder;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.application.ports.CardHolderPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import com.tpdbd.cardpurchases.domain.usecases.CreateCardHolderUseCase;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
public class CreateCardHolderUseCaseImpl implements CreateCardHolderUseCase {
    private final CardHolderPort cardHolderPort;
    private final BankPort bankPort;


    @Override
    public void invoke(CreateCardHolderCommand command) throws ParseException {
        var cardHolder = parseToCardHolder(command);
        cardHolderPort.save(cardHolder);
    }

    private CardHolder parseToCardHolder(CreateCardHolderCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return CardHolder
                .builder()
                .bankId(findBank(command.getBankId()))
                .completeName(command.getCompleteName())
                .dni(command.getDni())
                .cuil(command.getCuil())
                .address(command.getAddress())
                .telephone(command.getTelephone())
                .entry(formatter.parse(command.getEntry()))
                .build();
    }

    private Bank findBank(Long bankId) {
        return bankPort.findById(bankId).get();
    }
}
