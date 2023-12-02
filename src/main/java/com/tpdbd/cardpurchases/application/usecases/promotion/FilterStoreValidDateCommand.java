package com.tpdbd.cardpurchases.application.usecases.promotion;

import lombok.Builder;

import java.util.Date;

@Builder
public record FilterStoreValidDateCommand(String store, Date startDate, Date endDate) {
}
