package com.tpdbd.cardpurchases.application.usecases.payment;

import com.tpdbd.cardpurchases.application.ports.MonthlyPaymentPort;
import com.tpdbd.cardpurchases.application.ports.PaymentPort;
import com.tpdbd.cardpurchases.application.ports.QuotaPort;
import com.tpdbd.cardpurchases.domain.entities.Payment;
import com.tpdbd.cardpurchases.domain.entities.Quota;
import com.tpdbd.cardpurchases.domain.usecases.CreatePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@RequiredArgsConstructor
public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {
    private final PaymentPort paymentPort;
    private final MonthlyPaymentPort monthlyPaymentPort;
    private final QuotaPort quotaPort;

    @Transactional
    @Override
    public void invoke(CreatePaymentCommand command) throws ParseException {
        Payment payment = parseCommandToPayment(command);
        payment = paymentPort.save(payment);
        Quota quota = generateQuota(command, payment);
        quota = quotaPort.save(quota);
        var monthly = monthlyPaymentPort.findById(command.getMonthlyId()).get();
        monthly.getQuotas().add(quota);
        monthlyPaymentPort.save(monthly);
    }

    private Payment parseCommandToPayment(CreatePaymentCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return Payment
                .builder()
                .month(command.getMonth())
                .code(command.getCode())
                .year(command.getYear())
                .surchase(command.getSurchase())
                .firstExpiration(formatter.parse(command.getFirstExpiration()))
                .secondExpiration(formatter.parse(command.getSecondExpiration()))
                .totalPrice(command.getTotalPrice())
                .build();
    }

    private Quota generateQuota(CreatePaymentCommand command, Payment payment) {
        return Quota
                .builder()
                .paymentId(payment)
                .month(command.getMonth())
                .year(command.getYear())
                .price(command.getTotalPrice())
                .number(Math.toIntExact(command.getNumberQuota()))
                .build();
    }
}
