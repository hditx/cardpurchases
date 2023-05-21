package com.tpdbd.cardpurchases.application.card;

import com.tpdbd.cardpurchases.domain.*;
import com.tpdbd.cardpurchases.domain.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateCard {
    private final CardRepository cardRepository;
    private final BankRepository bankRepository;
    private final CardHolderRepository cardHolderRepository;
    private final MonthlyPaymentsRepository monthlyPaymentsRepository;
    private final CashPaymentRepository cashPaymentRepository;

    public CreateCard(CardRepository cardRepository, BankRepository bankRepository,
                      CardHolderRepository cardHolderRepository, MonthlyPaymentsRepository monthlyPaymentsRepository,
                      CashPaymentRepository cashPaymentRepository) {
        this.cardRepository = cardRepository;
        this.bankRepository = bankRepository;
        this.cardHolderRepository = cardHolderRepository;
        this.monthlyPaymentsRepository = monthlyPaymentsRepository;
        this.cashPaymentRepository = cashPaymentRepository;
    }

    public void invoke(CreateCardCommand command) throws ParseException {
        var card = parseToCard(command);
        card.setBankId(findBank(command.getBankId()));
        card.setCardHolderId(findCardHolder(command.getCardHolderId()));
        if (command.getCashPaymentsId().size() > 0) {
            card.setCashPaymentsId(findCashPayments(command.getCashPaymentsId()));
        }
        if (command.getCashPaymentsId().size() > 0) {
            card.setMonthlyPaymentsId(findMonthlyPayments(command.getMonthlyPaymentsId()));
        }
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

    private Bank findBank(Long bankId) {
        return bankRepository.findById(bankId).get();
    }

    private CardHolder findCardHolder(Long cardHolderId) {
        return cardHolderRepository.findById(cardHolderId).get();
    }

    private Set<CashPayment> findCashPayments(List<Long> cashPaymentsId) {
        Set<CashPayment> cashPayments = new HashSet<>();
        cashPaymentsId.forEach(id -> {
            var cashPayment = cashPaymentRepository.findById(id).get();
            cashPayments.add(cashPayment);
        });
        return cashPayments;
    }

    private Set<MonthlyPayments> findMonthlyPayments(List<Long> monthlyPaymentsId) {
        Set<MonthlyPayments> monthlyPayments = new HashSet<>();
        monthlyPaymentsId.forEach(id -> {
            var monthlyPayment = monthlyPaymentsRepository.findById(id).get();
            monthlyPayments.add(monthlyPayment);
        });
        return monthlyPayments;
    }
}
