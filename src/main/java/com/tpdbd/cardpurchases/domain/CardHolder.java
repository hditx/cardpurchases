package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card_holder")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CardHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String completeName;

    private String dni;

    private String cuil;

    private String address;

    private String telephone;

    private Date entry;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<Card>();

}
