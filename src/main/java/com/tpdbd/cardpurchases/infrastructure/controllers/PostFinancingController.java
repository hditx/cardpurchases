package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.financing.CreateFinancingCommand;
import com.tpdbd.cardpurchases.domain.usecase.CreateFinancingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/financing")
@RequiredArgsConstructor
public class PostFinancingController {
    private final CreateFinancingUseCase createFinancingUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateFinancingCommand command) throws ParseException {
        createFinancingUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
