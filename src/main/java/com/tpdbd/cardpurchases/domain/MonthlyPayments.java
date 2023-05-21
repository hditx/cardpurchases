package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monthly_payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MonthlyPayments extends Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float interest;

    private int numberOfQuotas;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card cardId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

    @ManyToMany
    private Set<Discount> discountsId;

    @ManyToMany
    private Set<Financing> financingsId;

}
