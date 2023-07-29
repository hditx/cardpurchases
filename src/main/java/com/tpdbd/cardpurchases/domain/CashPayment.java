package com.tpdbd.cardpurchases.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("cash_payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CashPayment extends Purchase{
    @Id
    private String id;
    private float storeDiscount;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "card_id")
    private Card cardId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "payment_id")
    private Payment paymentId;

//    @ManyToMany
    private Set<Discount> discountsId;

//    @ManyToMany
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
