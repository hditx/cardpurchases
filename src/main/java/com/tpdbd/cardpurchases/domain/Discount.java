package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "discount")
public class Discount extends Promotion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float discountPercentage;

    private float priceCap;

    private boolean onlyCash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

    public Discount() {super();}

    public Discount(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, float discountPercentage, float priceCap, boolean onlyCash) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.discountPercentage = discountPercentage;
        this.priceCap = priceCap;
        this.onlyCash = onlyCash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getPriceCap() {
        return priceCap;
    }

    public void setPriceCap(float priceCap) {
        this.priceCap = priceCap;
    }

    public boolean isOnlyCash() {
        return onlyCash;
    }

    public void setOnlyCash(boolean onlyCash) {
        this.onlyCash = onlyCash;
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
