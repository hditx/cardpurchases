package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.CardHolder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends MongoRepository<CardHolder, ObjectId> {
    CardHolder findByCuil(String cuil);
}
