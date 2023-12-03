package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.CardHolderPort;
import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import com.tpdbd.cardpurchases.infrastructure.repositories.CardHolderRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CardHolderPortImpl implements CardHolderPort {

    private final CardHolderRepository cardHolderRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public CardHolder save(CardHolder cardHolder) {
        return cardHolderRepository.save(cardHolder);
    }


    @Override
    public Optional<CardHolder> findById(String id) {
        return cardHolderRepository.findById(new ObjectId(id));
    }

    @Override
    public List<CardHolder> findCardHolderMostPurchase() {
        List<CardHolder> cardHolders = new ArrayList<>();
        var result = mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.group("cardId.cardHolderId.cuil")
                                .sum("finalAmount").as("totalPurchaseAmount"),
                        Aggregation.sort(Sort.by(Sort.Direction.DESC, "totalPurchaseAmount")),
                        Aggregation.limit(10)
                ), "purchase", Map.class
        ).getMappedResults();

        for (Map map : result) {
            var cardHolder = cardHolderRepository.findByCuil(map.get("_id").toString());
            cardHolders.add(cardHolder);
        }
        return cardHolders;
    }


}
