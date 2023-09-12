package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document("banks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Bank {
    @Id
    private String id;
    private String name;
    private String cuit;
    private String address;
    private String telephone;
}
