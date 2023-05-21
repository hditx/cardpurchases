package com.tpdbd.cardpurchases.application.cardholder;

import com.tpdbd.cardpurchases.domain.Bank;
import com.tpdbd.cardpurchases.domain.Card;
import com.tpdbd.cardpurchases.domain.CardHolder;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.CardHolderRepository;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateCardHolder {
    private final CardHolderRepository cardHolderRepository;
    private final CardRepository cardRepository;
    private final BankRepository bankRepository;

    public CreateCardHolder(CardHolderRepository cardHolderRepository, CardRepository cardRepository,
                            BankRepository bankRepository) {
        this.cardHolderRepository = cardHolderRepository;
        this.cardRepository = cardRepository;
        this.bankRepository = bankRepository;
    }

    public void invoke(CreateCardHolderCommand command) throws ParseException {
        var cardHolder = parseToCardHolder(command);
        if(command.getCardsId().size() > 0) {
            cardHolder.setCards(findCards(command.getCardsId()));
        }
        if(command.getBankId() != null) {
            cardHolder.setBankId(findBank(command.getBankId()));
        }
        cardHolderRepository.save(cardHolder);
    }

    private CardHolder parseToCardHolder(CreateCardHolderCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return CardHolder
                .builder()
                .completeName(command.getCompleteName())
                .dni(command.getDni())
                .cuil(command.getCuil())
                .address(command.getAddress())
                .telephone(command.getTelephone())
                .entry(formatter.parse(command.getEntry()))
                .build();
    }

    private Set<Card> findCards(List<Long> cardsId) {
        Set<Card> cards = new HashSet<>();
        cardsId.forEach(id -> {
            var card = cardRepository.findById(id).get();
            cards.add(card);
        });
        return cards;
    }

    private Bank findBank(Long bankId) {
        return bankRepository.findById(bankId).get();
    }
}
