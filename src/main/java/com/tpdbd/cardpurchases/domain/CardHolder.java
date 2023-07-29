package com.tpdbd.cardpurchases.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document("card_holders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CardHolder {
    @Id
    private String id;
    private String completeName;
    private String dni;
    private String cuil;
    private String address;
    private String telephone;
    private Date entry;
    private Bank bankId;
}
