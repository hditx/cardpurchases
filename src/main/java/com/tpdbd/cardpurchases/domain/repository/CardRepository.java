package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CardRepository extends MongoRepository<Card, String> {
    List<Card> findByExpirationDateLessThanEqual(Date expirationDate);
}
