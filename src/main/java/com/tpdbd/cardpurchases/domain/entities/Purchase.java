package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentVoucher;

    private String store;

    private String cuitStore;

    private float amount;

    private float finalAmount;

    public Purchase(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount) {
        this.paymentVoucher = paymentVoucher;
        this.store = store;
        this.cuitStore = cuitStore;
        this.amount = amount;
        this.finalAmount = finalAmount;
    }
}
