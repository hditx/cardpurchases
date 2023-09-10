package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.financing.CreateFinancingUseCaseImpl;
import com.tpdbd.cardpurchases.application.financing.CreateFinancingCommand;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.FinancingRepository;
import com.tpdbd.cardpurchases.domain.usecase.CreateFinancingUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/financing")
public class PostFinancingController {
    private final CreateFinancingUseCase createFinancingUseCaseImpl;

    public PostFinancingController(BankRepository bankRepository, FinancingRepository financingRepository) {
        this.createFinancingUseCaseImpl = new CreateFinancingUseCaseImpl(financingRepository, bankRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateFinancingCommand command) throws ParseException {
        createFinancingUseCaseImpl.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
