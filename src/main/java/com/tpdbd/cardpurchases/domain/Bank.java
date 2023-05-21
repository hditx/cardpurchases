package com.tpdbd.cardpurchases.domain;

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
    private String name;

    private String cuit;

    private String address;

    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CardHolder> cardHolders = new HashSet<CardHolder>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<Card>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Discount> discounts = new HashSet<Discount>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Financing> financings = new HashSet<Financing>();

}
