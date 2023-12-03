package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "cuit", nullable = false, unique = true, length = 11)
    private String cuit;

    @Column(name = "address", length = 55)
    private String address;

    @Column(name = "telephone", length = 20)
    private String telephone;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<CardHolder> cardHolders = new HashSet<CardHolder>();
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<Card>();
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Promotion> discounts = new HashSet<Promotion>();

}
