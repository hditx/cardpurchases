package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.CashPayment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CashPaymentRepository extends MongoRepository<CashPayment, String> {
}
