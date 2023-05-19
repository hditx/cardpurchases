package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;

    private String ccv;

    private String cardholderNameInCard;

    private Date since;

    private Date expirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<MonthlyPayments> monthlyPaymentsId = new HashSet<MonthlyPayments>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();


    public Card(){}
    public Card(String number, String ccv, String cardholderNameInCard, Date since, Date expirationDate) {
        this.number = number;
        this.ccv = ccv;
        this.cardholderNameInCard = cardholderNameInCard;
        this.since = since;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardHolder getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(CardHolder cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getCardholderNameInCard() {
        return cardholderNameInCard;
    }

    public void setCardholderNameInCard(String cardholderNameInCard) {
        this.cardholderNameInCard = cardholderNameInCard;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Set<MonthlyPayments> getMonthlyPaymentsId() {
        return monthlyPaymentsId;
    }

    public void setMonthlyPaymentsId(Set<MonthlyPayments> monthlyPaymentsId) {
        this.monthlyPaymentsId = monthlyPaymentsId;
    }

    public Set<CashPayment> getCashPaymentsId() {
        return cashPaymentsId;
    }

    public void setCashPaymentsId(Set<CashPayment> cashPaymentsId) {
        this.cashPaymentsId = cashPaymentsId;
    }


}
