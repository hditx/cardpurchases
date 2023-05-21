package com.tpdbd.cardpurchases.domain;

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
    private String code;

    private String month;

    private String year;

    private Date firstExpiration;

    private Date secondExpiration;

    private float surchase;

    private float totalPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

}
