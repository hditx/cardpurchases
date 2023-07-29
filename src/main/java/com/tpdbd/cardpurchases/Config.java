package com.tpdbd.cardpurchases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@Profile("mongodb-local")
@EnableMongoRepositories(basePackages = {"com.tpdbd.cardpurchases.domain.repository"})
@ComponentScan(basePackages = {"com.tpdbd.cardpurchases.domain.repository"})
public class Config {
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
}
