package com.tpdbd.cardpurchases.domain.usecases;

import com.tpdbd.cardpurchases.application.usecases.promotion.FilterStoreValidDateCommand;
import com.tpdbd.cardpurchases.domain.entities.Promotion;

import java.util.List;

public interface ValidPromotionStoreUseCase {
    List<Promotion> invoke(FilterStoreValidDateCommand filterStoreValidDate);
}
