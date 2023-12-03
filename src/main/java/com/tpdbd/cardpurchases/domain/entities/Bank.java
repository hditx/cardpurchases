package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.HashSet;
import java.util.Set;

@Document("banks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Bank {
    @Id
    private ObjectId id;
    @Field(name = "name", targetType = FieldType.STRING)
    private String name;
    @Field(name = "cuit", targetType = FieldType.STRING)
    private String cuit;
    @Field(name = "address", targetType = FieldType.STRING)
    private String address;
    @Field(name = "telephone", targetType = FieldType.STRING)
    private String telephone;
    @DBRef
    @Field(name = "cards_id", targetType = FieldType.ARRAY)
    private Set<Card> cardsId;
}
