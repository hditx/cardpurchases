package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByCode(String code);
    List<Payment> findByMonth(String month);
}
