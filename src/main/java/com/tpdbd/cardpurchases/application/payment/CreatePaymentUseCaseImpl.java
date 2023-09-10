package com.tpdbd.cardpurchases.application.payment;

import com.tpdbd.cardpurchases.domain.Payment;
import com.tpdbd.cardpurchases.domain.Quota;
import com.tpdbd.cardpurchases.domain.repository.MonthlyPaymentsRepository;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.repository.QuotaRepository;
import com.tpdbd.cardpurchases.domain.usecase.CreatePaymentUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {
    private final PaymentRepository paymentRepository;
    private final MonthlyPaymentsRepository monthlyPaymentsRepository;
    private final QuotaRepository quotaRepository;

    public CreatePaymentUseCaseImpl(PaymentRepository paymentRepository, MonthlyPaymentsRepository monthlyPaymentsRepository,
                                    QuotaRepository quotaRepository){
        this.paymentRepository = paymentRepository;
        this.monthlyPaymentsRepository = monthlyPaymentsRepository;
        this.quotaRepository = quotaRepository;
    }

    @Override
    public void invoke(CreatePaymentCommand command) throws ParseException {
        Payment payment = parseCommandToPayment(command);
        payment = paymentRepository.save(payment);
        Quota quota = generateQuota(command, payment);
        quotaRepository.save(quota);
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
        var monthly = monthlyPaymentsRepository.findById(command.getMonthlyId()).get();
        return Quota
                .builder()
                .paymentId(payment)
                .month(command.getMonth())
                .year(command.getYear())
                .price(command.getTotalPrice())
                .monthlyPaymentsId(monthly)
                .number(Math.toIntExact(command.getNumberQuota()))
                .build();
    }
}
