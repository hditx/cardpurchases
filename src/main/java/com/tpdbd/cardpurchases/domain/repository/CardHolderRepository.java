package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {
}
