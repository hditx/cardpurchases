package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;

    private String ccv;

    private String cardholderNameInCard;

    private Date since;

    private Date expirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<MonthlyPayments> monthlyPaymentsId = new HashSet<MonthlyPayments>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();

}
