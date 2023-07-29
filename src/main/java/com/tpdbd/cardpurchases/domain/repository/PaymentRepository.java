package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
