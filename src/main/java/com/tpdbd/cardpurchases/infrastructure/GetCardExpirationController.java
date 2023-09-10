package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.card.FindExpirationCardUseCaseImpl;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.usecase.FindExpirationCardUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card")
public class GetCardExpirationController {
    private final FindExpirationCardUseCase findExpirationCardUseCaseImpl;

    public GetCardExpirationController(CardRepository cardRepository) {
        this.findExpirationCardUseCaseImpl = new FindExpirationCardUseCaseImpl(cardRepository);
    }

    @GetMapping("/expiration-card")
    public ResponseEntity<?> invoke() {
        return ResponseEntity.ok(findExpirationCardUseCaseImpl.invoke());
    }
}
