package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "quota")
public class Quota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  int number;

    private float price;

    private String month;

    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_payments_id")
    private MonthlyPayments monthlyPaymentsId;

    public Quota(){}

    public Quota(int number, float price, String month, String year) {
        this.number = number;
        this.price = price;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public MonthlyPayments getMonthlyPaymentsId() {
        return monthlyPaymentsId;
    }

    public void setMonthlyPaymentsId(MonthlyPayments monthlyPaymentsId) {
        this.monthlyPaymentsId = monthlyPaymentsId;
    }
}
