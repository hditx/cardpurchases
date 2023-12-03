package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends MongoRepository<Discount, ObjectId> {
    Optional<Discount> findByCode(String code);
//    List<Discount> findByNameStoreAndBetweenValidityStartDateAndValidityEndDate(String nameStore, Date startDate, Date endDate);

}
