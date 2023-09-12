package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.bank.CreateBankCommand;
import com.tpdbd.cardpurchases.domain.usecase.CreateBankUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
@RequiredArgsConstructor
public class PostBankController {
    private final CreateBankUseCase createBankUseCase;


    @PostMapping
    private ResponseEntity<?> invoke(@RequestBody CreateBankCommand bankCommand) {
        createBankUseCase.invoke(bankCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
