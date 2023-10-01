package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quotas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Quota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number", length = 10, nullable = false)
    private  int number;
    @Column(name = "price", nullable = false, length = 20)
    private float price;
    @Column(name = "month", length = 10)
    private String month;
    @Column(name = "year", length = 10)
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_payments_id")
    private MonthlyPayments monthlyPaymentsId;

}
