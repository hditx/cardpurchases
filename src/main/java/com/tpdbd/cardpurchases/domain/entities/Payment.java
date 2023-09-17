package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "month", length = 3)
    private String month;
    @Column(name = "year", length = 4)
    private String year;

    @Column(name = "first_expiration", nullable = false)
    private Date firstExpiration;

    @Column(name = "second_expiration", nullable = false)
    private Date secondExpiration;

    @Column(name = "surchase", precision = 2)
    private float surchase;
    @Column(name = "total_price", precision = 2, nullable = false)
    private float totalPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

}
