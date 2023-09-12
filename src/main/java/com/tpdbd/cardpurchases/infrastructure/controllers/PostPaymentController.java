package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.payment.CreatePaymentCommand;
import com.tpdbd.cardpurchases.domain.usecases.CreatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PostPaymentController {
    private final CreatePaymentUseCase createPaymentUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePaymentCommand command) throws ParseException {
        createPaymentUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
