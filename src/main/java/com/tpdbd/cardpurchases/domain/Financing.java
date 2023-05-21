package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "financing")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Financing extends Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberOfQuotas;

    private float interes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

}
