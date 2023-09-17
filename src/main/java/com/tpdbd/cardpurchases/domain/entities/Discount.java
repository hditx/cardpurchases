package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Discount extends Promotion{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "discount_percentage", precision = 2)
    private float discountPercentage;

    @Column(name = "price_cap", precision = 2)
    private float priceCap;

    @Column(name = "only_cash", nullable = false)
    private boolean onlyCash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<MonthlyPayments> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Discount(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, float discountPercentage, float priceCap, boolean onlyCash) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.discountPercentage = discountPercentage;
        this.priceCap = priceCap;
        this.onlyCash = onlyCash;
    }
}
