package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card_holders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CardHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "complete_name", nullable = false, length = 55)
    private String completeName;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "cuil", nullable = false, length = 11)
    private String cuil;
    @Column(name = "address", length = 55)
    private String address;

    @Column(name = "telephone", length = 20)
    private String telephone;
    @Column(name = "entry", nullable = false)
    private Date entry;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Card> cards = new HashSet<Card>();

}
