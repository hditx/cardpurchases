package com.tpdbd.cardpurchases.domain.repository;

import com.tpdbd.cardpurchases.domain.Quota;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotaRepository extends MongoRepository<Quota, String> {
}
