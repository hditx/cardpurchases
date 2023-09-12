package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Financing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancingRepository extends MongoRepository<Financing, String> {
}
