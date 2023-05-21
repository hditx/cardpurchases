package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Financing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancingRepository extends JpaRepository<Financing, Long> {
}
