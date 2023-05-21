package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "cash_payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CashPayment extends Purchase{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float storeDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment paymentId;

    @ManyToMany
    private Set<Discount> discountsId;

    @ManyToMany
    private Set<Financing> financingsId;

}
