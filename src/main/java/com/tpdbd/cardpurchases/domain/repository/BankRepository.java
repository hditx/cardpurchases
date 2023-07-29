package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {
}
