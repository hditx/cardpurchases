package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Quota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotaRepository extends JpaRepository<Quota, Long> {
}
