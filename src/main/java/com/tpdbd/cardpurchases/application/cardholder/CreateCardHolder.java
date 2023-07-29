package com.tpdbd.cardpurchases.application.cardholder;

import com.tpdbd.cardpurchases.domain.Bank;
import com.tpdbd.cardpurchases.domain.CardHolder;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.CardHolderRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateCardHolder {
    private final CardHolderRepository cardHolderRepository;
    private final BankRepository bankRepository;

    public CreateCardHolder(CardHolderRepository cardHolderRepository, BankRepository bankRepository) {
        this.cardHolderRepository = cardHolderRepository;
        this.bankRepository = bankRepository;
    }

    public void invoke(CreateCardHolderCommand command) throws ParseException {
        var cardHolder = parseToCardHolder(command);
        cardHolderRepository.save(cardHolder);
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

    private Bank findBank(String bankId) {
        return bankRepository.findById(bankId).get();
    }
}
