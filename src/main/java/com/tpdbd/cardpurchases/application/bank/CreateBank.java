package com.tpdbd.cardpurchases.application.bank;

import com.tpdbd.cardpurchases.domain.*;
import com.tpdbd.cardpurchases.domain.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateBank {
    private final BankRepository bankRepository;
    private final CardHolderRepository cardHolderRepository;
    private final CardRepository cardRepository;
    private final DiscountRepository discountRepository;
    private final FinancingRepository financingRepository;

    public CreateBank(BankRepository bankRepository, CardHolderRepository cardHolderRepository,
                      CardRepository cardRepository, DiscountRepository discountRepository,
                      FinancingRepository financingRepository) {
        this.bankRepository = bankRepository;
        this.cardHolderRepository = cardHolderRepository;
        this.cardRepository = cardRepository;
        this.discountRepository = discountRepository;
        this.financingRepository = financingRepository;
    }

    public void invoke(CreateBankCommand command) {
        var bank = parseToBank(command);
        if (command.getCardsIs().size() > 0) {
            bank.setCards(findCards(command.getCardsIs()));
        }
        if (command.getCardHoldersId().size() > 0) {
            bank.setCardHolders(findCardsHolders(command.getCardHoldersId()));
        }
        if (command.getDiscountsId().size() > 0) {
            bank.setDiscounts(findDiscounts(command.getDiscountsId()));
        }
        if (command.getFinancingsId().size() > 0) {
            bank.setFinancings(findFinancings(command.getFinancingsId()));
        }
        bankRepository.save(bank);
    }

    private Bank parseToBank(CreateBankCommand command) {
        return Bank
                .builder()
                .telephone(command.getTelephone())
                .cuit(command.getCuit())
                .name(command.getName())
                .address(command.getAddress())
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

    private Set<CardHolder> findCardsHolders(List<Long> cardsHoldersId) {
        Set<CardHolder> cardsHolder = new HashSet<>();
        cardsHoldersId.forEach(id -> {
            var cardHolder = cardHolderRepository.findById(id).get();
            cardsHolder.add(cardHolder);
        });
        return cardsHolder;
    }

    private Set<Discount> findDiscounts(List<Long> discountsId) {
        Set<Discount> discounts = new HashSet<>();
        discountsId.forEach(id -> {
            var discount = discountRepository.findById(id).get();
            discounts.add(discount);
        });
        return discounts;
    }

    private Set<Financing> findFinancings(List<Long> financingsId) {
        Set<Financing> financings = new HashSet<>();
        financingsId.forEach(id -> {
            var financing = financingRepository.findById(id).get();
            financings.add(financing);
        });
        return financings;
    }
}
