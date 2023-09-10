package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.card.CreateCardUseCaseImpl;
import com.tpdbd.cardpurchases.application.card.CreateCardCommand;
import com.tpdbd.cardpurchases.domain.repository.*;
import com.tpdbd.cardpurchases.domain.usecase.CreateCardUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/card")
public class PostCardController {
    private final CreateCardUseCase createCardUseCaseImpl;

    public PostCardController(CardRepository cardRepository, BankRepository bankRepository,
                              CardHolderRepository cardHolderRepository) {
        this.createCardUseCaseImpl = new CreateCardUseCaseImpl(cardRepository, bankRepository,
                cardHolderRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateCardCommand command) throws ParseException {
        createCardUseCaseImpl.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
