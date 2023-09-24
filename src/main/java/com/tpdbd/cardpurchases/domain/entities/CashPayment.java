package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Set;

@Document("cash_payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CashPayment extends Purchase{
    @Id
    private String id;
    @Field(name = "store_discount", targetType = FieldType.DOUBLE)
    private float storeDiscount;
    @DBRef
    @Field(name = "card_id")
    private Card cardId;
    @DBRef
    @Field(name = "payment_id")
    private Payment paymentId;
    private Set<Discount> discountsId;
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
