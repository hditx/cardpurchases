package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.purchase.UpdatePurchaseDateCommand;
import com.tpdbd.cardpurchases.domain.usecase.UpdatePurchaseDateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/purchase")
@RequiredArgsConstructor
public class PutPurchaseController {
    private final UpdatePurchaseDateUseCase updatePurchaseDateUseCase;

    @PutMapping("/update")
    public ResponseEntity<?> invoke(@RequestBody UpdatePurchaseDateCommand command) throws ParseException {
        this.updatePurchaseDateUseCase.invoke(command);
        return ResponseEntity.ok().build();
    }
}
