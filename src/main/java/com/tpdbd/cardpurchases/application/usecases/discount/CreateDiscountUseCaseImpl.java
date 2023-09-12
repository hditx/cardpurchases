package com.tpdbd.cardpurchases.application.usecases.discount;

import com.tpdbd.cardpurchases.application.ports.BankPort;
import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.domain.usecases.CreateDiscountUseCase;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@RequiredArgsConstructor
public class CreateDiscountUseCaseImpl implements CreateDiscountUseCase {

    private final DiscountPort discountPort;
    private final BankPort bankPort;


    @Override
    public void invoke(CreateDiscountCommand command) throws ParseException {
        var discount = parseToDiscount(command);
        discount.setBankId(bankPort.findById(command.getBankId()).get());
        discountPort.save(discount);
    }

    private Discount parseToDiscount(CreateDiscountCommand command) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return Discount.builder()
                .code(command.getCode())
                .nameStore(command.getNameStore())
                .discountPercentage(command.getDiscountPercentage())
                .onlyCash(command.isOnlyCash())
                .comments(command.getComments())
                .priceCap(command.getPriceCap())
                .promotionTitle(command.getPromotionTitle())
                .cuitStore(command.getCuitStore())
                .validityEndDate(formatter.parse(command.getValidityEndDate()))
                .validityStartDate(formatter.parse(command.getValidityStartDate()))
                .build();
    }
}
