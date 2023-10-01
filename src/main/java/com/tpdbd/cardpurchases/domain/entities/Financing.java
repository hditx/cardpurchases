package com.tpdbd.cardpurchases.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorValue("financing")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Financing extends Promotion{

    @Column(name = "number_of_quotas", nullable = false, length = 2)
    private int numberOfQuotas;

    @Column(name = "interes", precision = 2)
    private float interes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @ManyToMany
    private Set<Purchase> monthlyPaymentsId;

    @ManyToMany
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Financing(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, Long id, int numberOfQuotas, float interes) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.numberOfQuotas = numberOfQuotas;
        this.interes = interes;
    }
}
