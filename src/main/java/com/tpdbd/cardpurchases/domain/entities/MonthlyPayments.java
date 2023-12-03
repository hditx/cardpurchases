package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.HashSet;
import java.util.Set;

@Document(collation = "purchase")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MonthlyPayments extends Purchase {
    @Field(name = "interest", targetType = FieldType.DOUBLE)
    private float interest;
    @Field(name = "number_of_quotas", targetType = FieldType.INT32)
    private int numberOfQuotas;
    @DBRef
    @Field(name = "card_id")
    private Card cardId;
    @DBRef
    @Field(name = "payment")
    private Payment payment;
    private Set<Quota> quotas = new HashSet<Quota>();
    private Set<Discount> discountsId;
    private Set<Financing> financingsId;

    @Builder
    public MonthlyPayments(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount, float interest, int numberOfQuotas, Card cardId, Payment payment, Set<Quota> quotas, Set<Discount> discountsId, Set<Financing> financingsId) {
        super(paymentVoucher, store, cuitStore, amount, finalAmount);
        this.interest = interest;
        this.numberOfQuotas = numberOfQuotas;
        this.cardId = cardId;
        this.quotas = quotas;
        this.discountsId = discountsId;
        this.financingsId = financingsId;
        this.payment = payment;
    }
}
