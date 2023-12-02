package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
import java.util.Set;

@Document("financings")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Financing extends Promotion{
    @Id
    private String id;
    @Field(name = "number_of_quotas", targetType = FieldType.INT32)
    private int numberOfQuotas;
    @Field(name = "interest", targetType = FieldType.DOUBLE)
    private float interest;
    @DBRef
    @Field(name = "bank_id")
    private Bank bankId;
    private Set<MonthlyPayments> monthlyPaymentsId;
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Financing(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, Long id, int numberOfQuotas, float interest) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.numberOfQuotas = numberOfQuotas;
        this.interest = interest;
    }
}
