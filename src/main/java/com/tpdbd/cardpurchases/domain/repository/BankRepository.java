package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
