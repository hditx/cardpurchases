package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.purchase.CreatePurchaseCommand;
import com.tpdbd.cardpurchases.domain.usecase.CreateMonthlyPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase/monthly")
@RequiredArgsConstructor
public class PostPurchaseMonthlyController {

    private final CreateMonthlyPurchaseUseCase createMonthlyPurchaseUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePurchaseCommand command) {
        createMonthlyPurchaseUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
