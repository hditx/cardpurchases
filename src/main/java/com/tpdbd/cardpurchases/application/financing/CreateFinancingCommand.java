package com.tpdbd.cardpurchases.application.financing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateFinancingCommand {
    private Long bankId;
    private String code;
    private String promotionTitle;
    private String nameStore;
    private String cuitStore;
    private String validityStartDate;
    private String validityEndDate;
    private String comments;
    private int numberOfQuotas;
    private float interes;
}
