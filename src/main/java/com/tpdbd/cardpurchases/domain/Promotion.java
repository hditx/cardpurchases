package com.tpdbd.cardpurchases.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Promotion {
    @Id
    private Long id;
    private String code;

    private String promotionTitle;

    private String nameStore;

    private String cuitStore;

    private Date validityStartDate;

    private Date validityEndDate;

    private String comments;

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
