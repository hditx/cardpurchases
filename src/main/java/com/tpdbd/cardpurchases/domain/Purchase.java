package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Purchase {
    @Id
    private Long id;
    private String paymentVoucher;

    private String store;

    private String cuitStore;

    private float amount;

    private float finalAmount;

}
