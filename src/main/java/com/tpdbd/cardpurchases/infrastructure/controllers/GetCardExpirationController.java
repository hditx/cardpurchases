package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.domain.usecases.FindExpirationCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class GetCardExpirationController {
    private final FindExpirationCardUseCase findExpirationCardUseCase;

    @GetMapping("/expiration-card")
    public ResponseEntity<?> invoke() {
        return ResponseEntity.ok(findExpirationCardUseCase.invoke());
    }
}
