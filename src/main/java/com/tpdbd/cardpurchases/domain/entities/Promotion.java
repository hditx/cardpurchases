package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", length = 6)
    private String code;
    @Column(name = "promotion_title", length = 20)
    private String promotionTitle;
    @Column(name = "name_store", length = 55)
    private String nameStore;
    @Column(name = "cuit_store", length = 15)
    private String cuitStore;
    @Column(name = "validity_start_date", nullable = false)
    private Date validityStartDate;
    @Column(name = "validity_end_date", nullable = false)
    private Date validityEndDate;
    @Column(name = "comments", length = 100)
    private String comments;

    @ManyToMany
    private Set<Purchase> purchases;

    public Promotion(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments) {
        this.code = code;
        this.promotionTitle = promotionTitle;
        this.nameStore = nameStore;
        this.cuitStore = cuitStore;
        this.validityStartDate = validityStartDate;
        this.validityEndDate = validityEndDate;
        this.comments = comments;
    }
}
