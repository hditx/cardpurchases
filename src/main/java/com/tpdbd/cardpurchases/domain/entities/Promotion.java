package com.tpdbd.cardpurchases.domain.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Document(collection = "promotion")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Promotion {
    @Id
    private ObjectId id;
    private String code;
    private String promotionTitle;
    @Field(name = "name_store")
    private String nameStore;
    private String cuitStore;
    private Date validityStartDate;
    private Date validityEndDate;
    private String comments;

    public Promotion(String code, String promotionTitle, String nameStore, String cuitStore, Date validityStartDate, Date validityEndDate, String comments) {
        this.code = code;
        this.promotionTitle = promotionTitle;
        this.nameStore = nameStore;
        this.cuitStore = cuitStore;
        this.validityStartDate = validityStartDate;
        this.validityEndDate = validityEndDate;
        this.comments = comments;
    }
}
