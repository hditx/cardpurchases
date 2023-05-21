package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
