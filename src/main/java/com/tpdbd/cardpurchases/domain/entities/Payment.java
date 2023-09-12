package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document("payments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Payment {
    @Id
    private String id;
    private String code;

    private String month;

    private String year;

    private Date firstExpiration;

    private Date secondExpiration;

    private float surchase;

    private float totalPrice;

//    @OneToMany(fetch = FetchType.LAZY)
    private Set<CashPayment> cashPaymentsId = new HashSet<CashPayment>();
//    @OneToMany(fetch = FetchType.LAZY)
    private Set<Quota> quotasId = new HashSet<Quota>();

}
