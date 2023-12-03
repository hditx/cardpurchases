package com.tpdbd.cardpurchases.application.usecases.card;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.application.ports.CardHolderPort;
import com.tpdbd.cardpurchases.application.ports.CardPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.domain.entities.Card;
import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import com.tpdbd.cardpurchases.domain.usecases.CreateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RequiredArgsConstructor
public class CreateCardUseCaseImpl implements CreateCardUseCase {
    private final CardPort cardPort;
    private final BankPort bankPort;
    private final CardHolderPort cardHolderPort;


    @Transactional
    @Override
    public void invoke(CreateCardCommand command) throws ParseException {
        var card = parseToCard(command);
        card.setBankId(findBank(command.getBankId()));
        card.setCardHolderId(findCardHolder(command.getCardHolderId()));
        cardPort.save(card);
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
        return bankPort.findById(bankId).get();
    }

    private CardHolder findCardHolder(String cardHolderId) {
        return cardHolderPort.findById(cardHolderId).get();
    }
}
