package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Financing;

import java.util.Optional;

public interface FinancingPort {
    Financing save(Financing financing);
    Optional<Financing> findById(String id);
}
