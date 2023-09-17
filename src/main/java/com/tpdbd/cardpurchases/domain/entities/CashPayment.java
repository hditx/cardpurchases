package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "cash_payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Builder
    public CashPayment(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount, float storeDiscount, Card cardId, Payment paymentId, Set<Discount> discountsId, Set<Financing> financingsId) {
        super(paymentVoucher, store, cuitStore, amount, finalAmount);
        this.storeDiscount = storeDiscount;
        this.cardId = cardId;
        this.paymentId = paymentId;
        this.discountsId = discountsId;
        this.financingsId = financingsId;
    }
}
