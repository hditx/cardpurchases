package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.CardHolderPort;
import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import com.tpdbd.cardpurchases.infrastructure.repositories.CardHolderRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardHolderPortImpl implements CardHolderPort {

    private final CardHolderRepository cardHolderRepository;

    @Override
    public CardHolder save(CardHolder cardHolder) {
        return cardHolderRepository.save(cardHolder);
    }


    @Override
    public Optional<CardHolder> findById(String id) {
        return cardHolderRepository.findById(new ObjectId(id));
    }
}
