package com.tpdbd.cardpurchases.application.purchase;



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
    private String cardId;
    private String paymentId;
    private List<String> discountsId;
    private List<String> financingsId;
    private String code;
    private String month;
    private String year;
    private String firstExpiration;
    private String secondExpiration;
    private float surchase;
    private float totalPrice;
}
