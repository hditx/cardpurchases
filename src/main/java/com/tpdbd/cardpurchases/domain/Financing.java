package com.tpdbd.cardpurchases.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document("financings")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Financing extends Promotion{
    @Id
    private String id;
    private int numberOfQuotas;
    private float interes;
    private Bank bankId;
    private Set<MonthlyPayments> monthlyPaymentsId;
    private Set<CashPayment> cashPaymentsId;

    @Builder
    public Financing(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments, Long id, int numberOfQuotas, float interes) {
        super(code, promotionTitle, nameStore, cuitStore, validityStartDate, validityEndDate, comments);
        this.numberOfQuotas = numberOfQuotas;
        this.interes = interes;
    }
}
