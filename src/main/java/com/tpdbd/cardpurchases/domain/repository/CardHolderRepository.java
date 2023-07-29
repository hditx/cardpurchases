package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.CardHolder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardHolderRepository extends MongoRepository<CardHolder, String> {
}
