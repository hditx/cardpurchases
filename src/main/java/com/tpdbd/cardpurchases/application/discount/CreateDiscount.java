package com.tpdbd.cardpurchases.application.discount;

import com.tpdbd.cardpurchases.domain.Discount;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateDiscount {

    private final DiscountRepository discountRepository;
    private final BankRepository bankRepository;

    public CreateDiscount(DiscountRepository discountRepository, BankRepository bankRepository) {
        this.discountRepository = discountRepository;
        this.bankRepository = bankRepository;
    }

    public void invoke(CreateDiscountCommand command) throws ParseException {
        var discount = parseToDiscount(command);
        discount.setBankId(bankRepository.findById(command.getBankId()).get());
        discountRepository.save(discount);
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
