package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Purchase {
    private String paymentVoucher;
    private String store;
    private String cuitStore;
    private float amount;
    private float finalAmount;
}
