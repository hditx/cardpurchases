package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
import java.util.Set;

@Document(collation = "promotion")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Discount extends Promotion{
    @Field(name = "discount_percentage", targetType = FieldType.DOUBLE)
    private float discountPercentage;
    @Field(name = "price_cap", targetType = FieldType.DOUBLE)
    private float priceCap;
    @Field(name = "only_cash", targetType = FieldType.BOOLEAN)
    private boolean onlyCash;
    @DBRef
    @Field(name = "bank_id")
    private Bank bankId;
    private Set<MonthlyPayments> monthlyPaymentsId;
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Discount(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, float discountPercentage, float priceCap, boolean onlyCash) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.discountPercentage = discountPercentage;
        this.priceCap = priceCap;
        this.onlyCash = onlyCash;
    }
}
