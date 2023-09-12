package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String number;
    private String ccv;
    private String cardholderNameInCard;
    private Date since;
    private Date expirationDate;
    private CardHolder cardHolderId;
    private Bank bankId;
}
