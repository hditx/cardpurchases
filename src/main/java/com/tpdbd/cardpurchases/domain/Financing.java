package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "financing")
public class Financing extends Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberOfQuotas;

    private float interes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

    public Financing(){
        super();
    }

    public Financing(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, int numberOfQuotas, float interes) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.numberOfQuotas = numberOfQuotas;
        this.interes = interes;
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

    public int getNumberOfQuotas() {
        return numberOfQuotas;
    }

    public void setNumberOfQuotas(int numberOfQuotas) {
        this.numberOfQuotas = numberOfQuotas;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
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
