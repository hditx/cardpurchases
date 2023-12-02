package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.card.CreateCardCommand;
import com.tpdbd.cardpurchases.domain.usecases.DeletePromotionByCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/promotion")
@RequiredArgsConstructor
public class DeletePromotionController {

    private final DeletePromotionByCodeUseCase deletePromotionByCodeUseCase;

    @DeleteMapping("/{code}")
    public ResponseEntity<?> invoke(@PathVariable("code") String code) throws ParseException {
        deletePromotionByCodeUseCase.invoke(code);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
