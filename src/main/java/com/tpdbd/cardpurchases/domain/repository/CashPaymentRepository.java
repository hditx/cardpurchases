package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.CashPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashPaymentRepository extends JpaRepository<CashPayment, Long> {
}
