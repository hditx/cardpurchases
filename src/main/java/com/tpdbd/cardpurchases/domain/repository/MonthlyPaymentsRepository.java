package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.MonthlyPayments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MonthlyPaymentsRepository extends MongoRepository<MonthlyPayments, String> {
}
