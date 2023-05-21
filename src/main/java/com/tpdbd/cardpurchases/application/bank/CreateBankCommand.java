package com.tpdbd.cardpurchases.application.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateBankCommand {
    private String name;
    private String cuit;
    private String telephone;
    private List<Long> cardHoldersId;
    private String address;
    private List<Long> cardsIs;
    private List<Long> discountsId;
    private List<Long> financingsId;
}
