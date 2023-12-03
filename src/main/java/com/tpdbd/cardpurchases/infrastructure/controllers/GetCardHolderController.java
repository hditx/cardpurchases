package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.domain.usecases.FindCardHolderMostPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card-holder")
@RequiredArgsConstructor
public class GetCardHolderController {
    private final FindCardHolderMostPurchaseUseCase cardHolderMostPurchaseUseCase;

    @GetMapping("/most")
    public ResponseEntity<?> invoke() {
        return ResponseEntity.ok(cardHolderMostPurchaseUseCase.invoke());
    }
}
