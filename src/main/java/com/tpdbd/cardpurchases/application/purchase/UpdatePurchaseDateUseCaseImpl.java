package com.tpdbd.cardpurchases.application.purchase;

import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.usecase.UpdatePurchaseDateUseCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdatePurchaseDateUseCaseImpl implements UpdatePurchaseDateUseCase {
    private final PaymentRepository paymentRepository;

    public UpdatePurchaseDateUseCaseImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void invoke(UpdatePurchaseDateCommand command) throws ParseException {
        var purchase = paymentRepository.findByCode(command.getCode());
        var date = parseToDate(command.getDate());
        purchase.setFirstExpiration(date);
        purchase.setSecondExpiration(date);
        paymentRepository.save(purchase);
    }

    private Date parseToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }
}
