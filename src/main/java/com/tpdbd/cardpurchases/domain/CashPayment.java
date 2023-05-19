package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cash_payment")
public class CashPayment extends Purchase{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float storeDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment paymentId;

    @ManyToMany
    private Set<Discount> discountsId;

    @ManyToMany
    private Set<Financing> financingsId;

    public CashPayment() {
        super();
    }
    public CashPayment(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount, float storeDiscount) {
        super(paymentVoucher, store, cuitStore, amount, finalAmount);
        this.storeDiscount = storeDiscount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getStoreDiscount() {
        return storeDiscount;
    }

    public void setStoreDiscount(float storeDiscount) {
        this.storeDiscount = storeDiscount;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
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
