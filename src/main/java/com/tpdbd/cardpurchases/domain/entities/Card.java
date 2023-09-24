package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document("cards")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Card {
    @Id
    private String id;
    @Field(name = "number", targetType = FieldType.STRING)
    private String number;
    @Field(name = "ccv", targetType = FieldType.STRING)
    private String ccv;
    @Field(name = "cardholer_name_in_card", targetType = FieldType.STRING)
    private String cardholderNameInCard;
    @Field(name = "since", targetType = FieldType.DATE_TIME)
    private Date since;
    @Field(name = "expiration_date", targetType = FieldType.DATE_TIME)
    private Date expirationDate;
    @DBRef
    @Field(name = "card_holder_id")
    private CardHolder cardHolderId;
    @DBRef
    @Field(name = "bank_id")
    private Bank bankId;
}
