package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.cardholder.CreateCardHolder;
import com.tpdbd.cardpurchases.application.cardholder.CreateCardHolderCommand;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.CardHolderRepository;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/card-holder")
public class PostCardHolderController {
    private final CreateCardHolder createCardHolder;
    public PostCardHolderController(BankRepository bankRepository, CardRepository cardRepository,
                              CardHolderRepository cardHolderRepository) {
        this.createCardHolder = new CreateCardHolder(cardHolderRepository, cardRepository, bankRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateCardHolderCommand command) throws ParseException {
        createCardHolder.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
