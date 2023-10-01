package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Financing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FinancingRepository extends JpaRepository<Financing, Long> {

    Optional<Financing> findByCode(String code);

    List<Financing> findByStoreNameAndBetweenValidityStartDateAndValidityEndDate(String storeName,
                                                                                 Date validityStartDate,
                                                                                 Date validityEndDate);
}
