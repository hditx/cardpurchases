package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.cardholder.CreateCardHolderCommand;
import com.tpdbd.cardpurchases.domain.usecase.CreateCardHolderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/card-holder")
@RequiredArgsConstructor
public class PostCardHolderController {
    private final CreateCardHolderUseCase createCardHolderUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateCardHolderCommand command) throws ParseException {
        createCardHolderUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
