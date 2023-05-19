package com.tpdbd.cardpurchases.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class GetBankController {

    @GetMapping
    public ResponseEntity<?> invoke() {
        return ResponseEntity.ok().build();
    }
}
