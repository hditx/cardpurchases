package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.bank.CreateBankCommand;
import com.tpdbd.cardpurchases.application.bank.CreateBank;
import com.tpdbd.cardpurchases.domain.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class PostBankController {
    private final CreateBank createBank;

    public PostBankController(BankRepository bankRepository) {
        this.createBank = new CreateBank(bankRepository);
    }

    @PostMapping
    private ResponseEntity<?> invoke(@RequestBody CreateBankCommand bankCommand) {
        createBank.invoke(bankCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
