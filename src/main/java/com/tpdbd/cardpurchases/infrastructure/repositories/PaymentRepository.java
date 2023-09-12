package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByCode(String code);
    List<Payment> findByMonth(String month);
}
