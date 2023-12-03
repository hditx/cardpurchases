package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document("payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Payment {
    @Id
    private ObjectId id;
    @Field(name = "code", targetType = FieldType.STRING)
    private String code;
    @Field(name = "month", targetType = FieldType.STRING)
    private String month;
    @Field(name = "year", targetType = FieldType.STRING)
    private String year;
    @Field(name = "first_expiration", targetType = FieldType.DATE_TIME)
    private Date firstExpiration;
    @Field(name = "second_expiration", targetType = FieldType.DATE_TIME)
    private Date secondExpiration;
    @Field(name = "surchase", targetType = FieldType.DOUBLE)
    private float surchase;
    @Field(name = "total_price", targetType = FieldType.DOUBLE)
    private float totalPrice;
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();
    private Set<Quota> quotasId = new HashSet<Quota>();

}
