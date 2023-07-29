package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {
}
