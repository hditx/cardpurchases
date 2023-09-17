package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monthly_payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
