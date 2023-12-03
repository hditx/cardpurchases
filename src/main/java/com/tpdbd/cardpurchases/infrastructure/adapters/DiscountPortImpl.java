package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.infrastructure.repositories.DiscountRepository;
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
public class DiscountPortImpl implements DiscountPort {

    private final MongoTemplate mongoTemplate;

    private final DiscountRepository discountRepository;

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Optional<Discount> findById(String id) {
        return discountRepository.findById(new ObjectId(id));
    }

    @Override
    public Optional<Discount> findByCode(String code) {
        return discountRepository.findByCode(code);
    }

    @Override
    public void delete(Discount discount) {
        discountRepository.delete(discount);
    }

    @Override
    public List<Discount> findByStoreNameAndBetweenStartDateAndEndDate(FilterStoreValidDateCommand filterStoreValidDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("storeName").is(filterStoreValidDate.store())
                .and("validityStartDate").gte(filterStoreValidDate.startDate())
                .and("validityEndDate").lte(filterStoreValidDate.endDate()));

        return mongoTemplate.find(query, Discount.class, "promotion");
    }
}
