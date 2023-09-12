package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.QuotaPort;
import com.tpdbd.cardpurchases.domain.entities.Quota;
import com.tpdbd.cardpurchases.infrastructure.repositories.QuotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuotaPortImpl implements QuotaPort {

    private final QuotaRepository quotaRepository;

    @Override
    public Quota save(Quota quota) {
        return quotaRepository.save(quota);
    }
}
