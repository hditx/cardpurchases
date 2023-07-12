package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quota")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Quota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  int number;
    private float price;
    private String month;
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_payments_id")
    private MonthlyPayments monthlyPaymentsId;

}
