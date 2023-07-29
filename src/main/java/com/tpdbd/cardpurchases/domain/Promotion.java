package com.tpdbd.cardpurchases.domain;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Promotion {
    private String code;
    private String promotionTitle;
    private String nameStore;
    private String cuitStore;
    private Date validityStartDate;
    private Date validityEndDate;
    private String comments;
}
