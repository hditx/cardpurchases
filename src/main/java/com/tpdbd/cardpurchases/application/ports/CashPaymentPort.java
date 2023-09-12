package com.tpdbd.cardpurchases.application.ports;

import com.tpdbd.cardpurchases.domain.entities.CashPayment;

public interface CashPaymentPort {
    CashPayment save(CashPayment cashPayment);
}
