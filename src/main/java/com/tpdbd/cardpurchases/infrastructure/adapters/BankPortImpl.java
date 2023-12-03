package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.domain.entities.Bank;
import com.tpdbd.cardpurchases.infrastructure.repositories.BankRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BankPortImpl implements BankPort {
    private final BankRepository bankRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Optional<Bank> findById(String id) {
        return bankRepository.findById(new ObjectId(id));
    }

    @Override
    public Bank findMostPaymentWithCard() {
        var result = mongoTemplate.aggregate(
            Aggregation.newAggregation(
                    Aggregation.group("cardId.bankId.name")
                            .sum("finalAmount").as("total"),
                    Aggregation.sort(Sort.by(Sort.Direction.DESC, "total")),
                    Aggregation.limit(1)
            ), "purchase", Map.class
        ).getMappedResults();
        return bankRepository.findByName(result.get(0).get("_id").toString());
    }

}
