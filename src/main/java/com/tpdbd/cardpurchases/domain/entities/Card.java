package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number", unique = true, nullable = false, length = 16)
    private String number;

    @Column(name = "ccv", nullable = false, length = 3)
    private String ccv;

    @Column(name = "cardholder_name_in_card", length = 50)
    private String cardholderNameInCard;

    @Column(name = "since", nullable = false)
    private Date since;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Purchase> purchasesId = new HashSet<Purchase>();

}
