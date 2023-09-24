package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

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
    @Field(name = "interest", targetType = FieldType.DOUBLE)
    private float interest;
    @Field(name = "number_of_quotas", targetType = FieldType.INT32)
    private int numberOfQuotas;
    @DBRef
    @Field(name = "card_id")
    private Card cardId;
    private Set<Quota> quotasId = new HashSet<Quota>();
    private Set<Discount> discountsId;
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
