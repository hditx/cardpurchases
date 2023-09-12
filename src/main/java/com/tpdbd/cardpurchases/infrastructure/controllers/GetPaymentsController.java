package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.domain.usecases.FindTotalPaymentMonthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class GetPaymentsController {
    private final FindTotalPaymentMonthUseCase findTotalPaymentMonthUseCase;

    @GetMapping("/{month}")
    public ResponseEntity<?> invoke(@PathVariable String month) {
        return ResponseEntity.ok(this.findTotalPaymentMonthUseCase.invoke(month));
    }
}
