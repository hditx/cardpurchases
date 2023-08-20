package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.card.FindExpirationCard;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card")
public class GetCardExpirationController {
    private final FindExpirationCard findExpirationCard;

    public GetCardExpirationController(CardRepository cardRepository) {
        this.findExpirationCard = new FindExpirationCard(cardRepository);
    }

    @GetMapping("/expiration-card")
    public ResponseEntity<?> invoke() {
        return ResponseEntity.ok(findExpirationCard.invoke());
    }
}
