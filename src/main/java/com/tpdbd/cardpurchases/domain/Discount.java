package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Discount extends Promotion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float discountPercentage;

    private float priceCap;

    private boolean onlyCash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

}
