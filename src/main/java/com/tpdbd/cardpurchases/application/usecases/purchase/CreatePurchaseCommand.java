package com.tpdbd.cardpurchases.application.usecases.purchase;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreatePurchaseCommand {
    private String paymentVoucher;
    private String store;
    private String cuitStore;
    private float amount;
    private float finalAmount;
    private float storeDiscount;
    private float interest;
    private int numberOfQuotas;
    private Long cardId;
    private Long paymentId;
    private List<Long> discountsId;
    private List<Long> financingsId;
    private String code;
    private String month;
    private String year;
    private String firstExpiration;
    private String secondExpiration;
    private float surchase;
    private float totalPrice;
}
