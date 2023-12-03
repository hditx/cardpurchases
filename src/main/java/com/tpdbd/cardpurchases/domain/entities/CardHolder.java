package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document("card_holders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CardHolder {
    @Id
    private ObjectId id;
    @Field(name = "complete_name", targetType = FieldType.STRING)
    private String completeName;
    @Field(name = "dni", targetType = FieldType.STRING)
    private String dni;
    @Field(name = "cuil", targetType = FieldType.STRING)
    private String cuil;
    @Field(name = "address", targetType = FieldType.STRING)
    private String address;
    @Field(name = "telephone", targetType = FieldType.STRING)
    private String telephone;
    @Field(name = "entry", targetType = FieldType.DATE_TIME)
    private Date entry;
    @DBRef
    @Field(name = "bank_id")
    private Bank bankId;
}
