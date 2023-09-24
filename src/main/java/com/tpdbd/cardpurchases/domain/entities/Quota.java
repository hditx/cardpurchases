package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document("quotas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Quota {
    @Id
    private String id;
    @Field(name = "number", targetType = FieldType.INT32)
    private  int number;
    @Field(name = "price", targetType = FieldType.DOUBLE)
    private float price;
    @Field(name = "month", targetType = FieldType.STRING)
    private String month;
    @Field(name = "year", targetType = FieldType.STRING)
    private String year;
    @DBRef
    @Field(name = "payment_id")
    private Payment paymentId;
    @DBRef
    @Field(name = "monthly_payments_id")
    private MonthlyPayments monthlyPaymentsId;

}
