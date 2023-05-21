package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.MonthlyPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyPaymentsRepository extends JpaRepository<MonthlyPayments, Long> {
}
