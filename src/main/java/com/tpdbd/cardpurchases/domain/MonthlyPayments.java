package com.tpdbd.cardpurchases.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document("monthly_payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MonthlyPayments extends Purchase {
    @Id
    private String id;
    private float interest;

    private int numberOfQuotas;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "card_id")
    private Card cardId;

//    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

//    @ManyToMany
    private Set<Discount> discountsId;

//    @ManyToMany
    private Set<Financing> financingsId;

    @Builder
    public MonthlyPayments(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount, float interest, int numberOfQuotas, Card cardId, Set<Quota> quotasId, Set<Discount> discountsId, Set<Financing> financingsId) {
        super(paymentVoucher, store, cuitStore, amount, finalAmount);
        this.interest = interest;
        this.numberOfQuotas = numberOfQuotas;
        this.cardId = cardId;
        this.quotasId = quotasId;
        this.discountsId = discountsId;
        this.financingsId = financingsId;
    }
}
