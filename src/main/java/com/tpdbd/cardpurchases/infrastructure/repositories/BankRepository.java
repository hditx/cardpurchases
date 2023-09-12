package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {
}
