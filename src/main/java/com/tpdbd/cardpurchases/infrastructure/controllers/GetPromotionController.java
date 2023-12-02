package com.tpdbd.cardpurchases.infrastructure.controllers;

import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.usecases.ValidPromotionStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/v1/promotion")
@RequiredArgsConstructor
public class GetPromotionController {

    private final ValidPromotionStoreUseCase validPromotionStoreUseCase;

    @GetMapping("/{store}/{startDate}/{endDate}")
    public ResponseEntity<?> invoke(@PathVariable("store") String store,
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        var filter = FilterStoreValidDateCommand
                .builder()
                .store(store)
                .startDate(format.parse(startDate))
                .endDate(format.parse(endDate))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(validPromotionStoreUseCase.invoke(filter));
    }
}
