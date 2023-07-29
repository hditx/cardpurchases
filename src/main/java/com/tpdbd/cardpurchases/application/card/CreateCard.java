package com.tpdbd.cardpurchases.application.card;

import com.tpdbd.cardpurchases.domain.*;
import com.tpdbd.cardpurchases.domain.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateCard {
    private final CardRepository cardRepository;
    private final BankRepository bankRepository;
    private final CardHolderRepository cardHolderRepository;

    public CreateCard(CardRepository cardRepository, BankRepository bankRepository,
                      CardHolderRepository cardHolderRepository) {
        this.cardRepository = cardRepository;
        this.bankRepository = bankRepository;
        this.cardHolderRepository = cardHolderRepository;
    }

    public void invoke(CreateCardCommand command) throws ParseException {
        var card = parseToCard(command);
        card.setBankId(findBank(command.getBankId()));
        card.setCardHolderId(findCardHolder(command.getCardHolderId()));
        cardRepository.save(card);
    }

    private Card parseToCard(CreateCardCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return Card.builder()
                .ccv(command.getCcv())
                .cardholderNameInCard(command.getCardHolderNameInCard())
                .number(command.getNumber())
                .since(formatter.parse(command.getSince()))
                .expirationDate(formatter.parse(command.getExpirationDate()))
                .build();
    }

    private Bank findBank(String bankId) {
        return bankRepository.findById(bankId).get();
    }

    private CardHolder findCardHolder(String cardHolderId) {
        return cardHolderRepository.findById(cardHolderId).get();
    }

}
