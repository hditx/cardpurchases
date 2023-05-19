package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monthly_payments")
public class MonthlyPayments extends Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float interest;

    private int numberOfQuotas;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card cardId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

    @ManyToMany
    private Set<Discount> discountsId;

    @ManyToMany
    private Set<Financing> financingsId;

    public MonthlyPayments(){
        super();
    }
    public MonthlyPayments(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount, float interest, int numberOfQuotas) {
        super(paymentVoucher, store, cuitStore, amount, finalAmount);
        this.interest = interest;
        this.numberOfQuotas = numberOfQuotas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getNumberOfQuotas() {
        return numberOfQuotas;
    }

    public void setNumberOfQuotas(int numberOfQuotas) {
        this.numberOfQuotas = numberOfQuotas;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public Set<Quota> getQuotasId() {
        return quotasId;
    }

    public void setQuotasId(Set<Quota> quotasId) {
        this.quotasId = quotasId;
    }

    public Set<Discount> getDiscountsId() {
        return discountsId;
    }

    public void setDiscountsId(Set<Discount> discountsId) {
        this.discountsId = discountsId;
    }

    public Set<Financing> getFinancingsId() {
        return financingsId;
    }

    public void setFinancingsId(Set<Financing> financingsId) {
        this.financingsId = financingsId;
    }
}
