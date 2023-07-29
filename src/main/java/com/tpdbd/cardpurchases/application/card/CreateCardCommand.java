package com.tpdbd.cardpurchases.application.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateCardCommand {
    private String number;
    private String ccv;
    private String cardHolderNameInCard;
    private String since;
    private String expirationDate;
    private String cardHolderId;
    private String bankId;
}
