package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Financing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FinancingRepository extends MongoRepository<Financing, String> {
    Optional<Financing> findByCode(String code);

    List<Financing> findByStoreNameAndBetweenValidityStartDateAndValidityEndDate(String store, Date startDate, Date endDate);
}
