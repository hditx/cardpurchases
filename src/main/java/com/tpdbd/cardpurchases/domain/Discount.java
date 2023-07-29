package com.tpdbd.cardpurchases.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document("discounts")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Discount extends Promotion{
    @Id
    private String id;

    private float discountPercentage;

    private float priceCap;

    private boolean onlyCash;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bank_id")
    private Bank bankId;

//    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

//    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Discount(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, float discountPercentage, float priceCap, boolean onlyCash) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.discountPercentage = discountPercentage;
        this.priceCap = priceCap;
        this.onlyCash = onlyCash;
    }
}
