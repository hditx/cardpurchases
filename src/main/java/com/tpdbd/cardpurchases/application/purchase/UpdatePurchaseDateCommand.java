package com.tpdbd.cardpurchases.application.purchase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatePurchaseDateCommand {
    private String code;
    private String date;
}
