package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.CardPort;
import com.tpdbd.cardpurchases.domain.entities.Card;
import com.tpdbd.cardpurchases.infrastructure.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardPortImpl implements CardPort {
    private final CardRepository cardRepository;

    @Override
    public List<Card> findByExpirationDateLessThanEqual(Date expirationDate) {
        return cardRepository.findByExpirationDateLessThanEqual(expirationDate);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

}
