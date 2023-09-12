package com.tpdbd.cardpurchases.application.usecases.purchase;

import com.tpdbd.cardpurchases.application.ports.PaymentPort;
import com.tpdbd.cardpurchases.domain.usecases.UpdatePurchaseDateUseCase;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
public class UpdatePurchaseDateUseCaseImpl implements UpdatePurchaseDateUseCase {
    private final PaymentPort paymentPort;


    public void invoke(UpdatePurchaseDateCommand command) throws ParseException {
        var purchase = paymentPort.findByCode(command.getCode());
        var date = parseToDate(command.getDate());
        purchase.setFirstExpiration(date);
        purchase.setSecondExpiration(date);
        paymentPort.save(purchase);
    }

    private Date parseToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }
}
