package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import com.tpdbd.cardpurchases.infrastructure.repositories.FinancingRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FinancingPortImpl implements FinancingPort {

    private final FinancingRepository financingRepository;

    private final MongoTemplate mongoTemplate;

    @Override
    public Financing save(Financing financing) {
        return financingRepository.save(financing);
    }

    @Override
    public Optional<Financing> findById(String id) {
        return financingRepository.findById(new ObjectId(id));
    }

    @Override
    public Optional<Financing> findByCode(String code) {
        return financingRepository.findByCode(code);
    }

    @Override
    public void delete(Financing financing) {
        financingRepository.delete(financing);
    }

    @Override
    public List<Financing> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("storeName").is(filterStoreValidDate.store())
                .and("validityStartDate").gte(filterStoreValidDate.startDate())
                .and("validityEndDate").lte(filterStoreValidDate.endDate()));

        return mongoTemplate.find(query, Financing.class, "promotion");
    }
}
