package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountRepository extends MongoRepository<Discount, String> {
}
