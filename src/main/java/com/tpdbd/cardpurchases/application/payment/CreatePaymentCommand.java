package com.tpdbd.cardpurchases.application.payment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreatePaymentCommand {
    private String code;
    private String month;
    private String year;
    private String firstExpiration;
    private String secondExpiration;
    private float surchase;
    private float totalPrice;
    private List<String> cashPaymentsId;
    private String monthlyId;
    private Long numberQuota;
}
