package com.tpdbd.cardpurchases.application.usecases.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateDiscountCommand {
    private String bankId;
    private String code;
    private String promotionTitle;
    private String nameStore;
    private String cuitStore;
    private String validityStartDate;
    private String validityEndDate;
    private String comments;
    private float discountPercentage;
    private float priceCap;
    private boolean onlyCash;
}
