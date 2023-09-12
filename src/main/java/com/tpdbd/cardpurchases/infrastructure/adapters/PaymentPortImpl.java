package com.tpdbd.cardpurchases.infrastructure.adapters;

import com.tpdbd.cardpurchases.application.ports.PaymentPort;
import com.tpdbd.cardpurchases.domain.entities.Payment;
import com.tpdbd.cardpurchases.infrastructure.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentPortImpl implements PaymentPort {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment findByCode(String code) {
        return paymentRepository.findByCode(code);
    }

    @Override
    public List<Payment> findByMonth(String month) {
        return paymentRepository.findByMonth(month);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
