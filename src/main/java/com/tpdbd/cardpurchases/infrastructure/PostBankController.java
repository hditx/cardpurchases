package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.bank.CreateBankCommand;
import com.tpdbd.cardpurchases.application.bank.CreateBankUseCaseImpl;
import com.tpdbd.cardpurchases.domain.repository.*;
import com.tpdbd.cardpurchases.domain.usecase.CreateBankUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class PostBankController {
    private final CreateBankUseCase createBankUseCaseImpl;

    public PostBankController(BankRepository bankRepository) {
        this.createBankUseCaseImpl = new CreateBankUseCaseImpl(bankRepository);
    }

    @PostMapping
    private ResponseEntity<?> invoke(@RequestBody CreateBankCommand bankCommand) {
        createBankUseCaseImpl.invoke(bankCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
