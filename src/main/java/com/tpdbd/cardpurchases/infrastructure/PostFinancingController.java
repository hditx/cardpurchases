package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.financing.CreateFinancing;
import com.tpdbd.cardpurchases.application.financing.CreateFinancingCommand;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.FinancingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/financing")
public class PostFinancingController {
    private final CreateFinancing createFinancing;

    public PostFinancingController(BankRepository bankRepository, FinancingRepository financingRepository) {
        this.createFinancing = new CreateFinancing(financingRepository, bankRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateFinancingCommand command) throws ParseException {
        createFinancing.invoke(command);
        return ResponseEntity.ok().build();
    }
}
