package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.discount.CreateDiscountCommand;
import com.tpdbd.cardpurchases.domain.usecases.CreateDiscountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/discount")
@RequiredArgsConstructor
public class PostDiscountController {

    private final CreateDiscountUseCase createDiscountUseCase;


    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateDiscountCommand command) throws ParseException {
        createDiscountUseCase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
