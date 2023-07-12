package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
