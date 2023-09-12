package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends MongoRepository<Discount, String> {
}
