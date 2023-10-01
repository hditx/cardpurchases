package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.domain.usecases.FindBankMostPaymentWithCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/bank")
@RequiredArgsConstructor
public class GetBankController {
    private final FindBankMostPaymentWithCardUseCase findBankMostPaymentWithCardUseCase;
    @GetMapping("/most-payment")
    public ResponseEntity<?> invoke() {
        return ResponseEntity.status(OK).body(findBankMostPaymentWithCardUseCase.invoke());
    }
}
