package com.tpdbd.cardpurchases.application.usecases.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public final class CreateBankCommand {
    private String name;
    private String cuit;
    private String telephone;
    private String address;
}
