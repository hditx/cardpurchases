package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "purchases")
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
    @Column(name = "payment_voucher", length = 10)
    private String paymentVoucher;
    @Column(name = "store", length = 55)
    private String store;
    @Column(name = "cuit_store", length = 13, nullable = false)
    private String cuitStore;
    @Column(name = "amount", precision = 2, nullable = false)
    private float amount;
    @Column(name = "final_amount", precision = 2, nullable = false)
    private float finalAmount;

    public Purchase(String paymentVoucher, String store, String cuitStore, float amount, float finalAmount) {
        this.paymentVoucher = paymentVoucher;
        this.store = store;
        this.cuitStore = cuitStore;
        this.amount = amount;
        this.finalAmount = finalAmount;
    }
}
