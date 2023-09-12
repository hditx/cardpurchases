package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quotas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Quota {
    @Id
    private String id;
    private  int number;
    private float price;
    private String month;
    private String year;
    private Payment paymentId;
    private MonthlyPayments monthlyPaymentsId;

}
