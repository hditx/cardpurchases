package com.tpdbd.cardpurchases.infrastructure.controllers;


import com.tpdbd.cardpurchases.application.usecases.purchase.CreatePurchaseCommand;
import com.tpdbd.cardpurchases.domain.usecases.CreateCashPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase/cash")
@RequiredArgsConstructor
public class PostPurchaseCashController {

    private final CreateCashPurchaseUseCase createCashPurchaseUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePurchaseCommand command) {
        createCashPurchaseUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
