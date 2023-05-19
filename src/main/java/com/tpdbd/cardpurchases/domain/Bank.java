package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")
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

    public Bank() {}
    public Bank(String name, String cuit, String address, String telephone) {
        this.name = name;
        this.cuit = cuit;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CardHolder> getCardHolders() {
        return cardHolders;
    }

    public void setCardHolders(Set<CardHolder> cardHolders) {
        this.cardHolders = cardHolders;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }

    public Set<Financing> getFinancings() {
        return financings;
    }

    public void setFinancings(Set<Financing> financings) {
        this.financings = financings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
