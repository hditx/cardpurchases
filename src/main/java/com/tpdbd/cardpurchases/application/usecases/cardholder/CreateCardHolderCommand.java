package com.tpdbd.cardpurchases.application.usecases.cardholder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateCardHolderCommand {
    private String completeName;
    private String dni;
    private String cuil;
    private String telephone;
    private String address;
    private String entry;
    private String bankId;
}
