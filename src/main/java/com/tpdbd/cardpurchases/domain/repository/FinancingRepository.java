package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Financing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinancingRepository extends MongoRepository<Financing, String> {
}
