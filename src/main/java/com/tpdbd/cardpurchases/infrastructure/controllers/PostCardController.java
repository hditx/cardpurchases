package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.card.CreateCardCommand;
import com.tpdbd.cardpurchases.domain.usecase.CreateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class PostCardController {
    private final CreateCardUseCase createCardUseCase;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateCardCommand command) throws ParseException {
        createCardUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
