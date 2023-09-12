package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.Quota;

public interface QuotaPort {
    Quota save(Quota quota);
}
