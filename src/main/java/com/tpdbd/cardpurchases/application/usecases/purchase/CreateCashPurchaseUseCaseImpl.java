package com.tpdbd.cardpurchases.application.usecases.purchase;

import com.tpdbd.cardpurchases.application.ports.CardPort;
import com.tpdbd.cardpurchases.application.ports.CashPaymentPort;
import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.ports.PaymentPort;
import com.tpdbd.cardpurchases.domain.entities.CashPayment;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.domain.entities.Payment;
import com.tpdbd.cardpurchases.domain.usecase.CreateCashPurchaseUseCase;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class CreateCashPurchaseUseCaseImpl implements CreateCashPurchaseUseCase {
    private final CashPaymentPort cashPaymentPort;
    private final CardPort cardPort;
    private final DiscountPort discountPort;
    private final PaymentPort paymentPort;

    @Override
    public void invoke(CreatePurchaseCommand command) {
        Payment payment = parseToPayment(command);
        payment = paymentPort.save(payment);
        CashPayment cashPayment = parseCommandToCashPayment(command);
        cashPayment.setPaymentId(payment);
        cashPaymentPort.save(cashPayment);
    }

    private CashPayment parseCommandToCashPayment(CreatePurchaseCommand command) {
        var card = cardPort.findById(command.getCardId()).get();
        var discounts = findDiscounts(command.getDiscountsId());
        var finalAmount = calculateFinalAmount(discounts, command);
        return CashPayment
                .builder()
                .cardId(card)
                .discountsId(discounts)
                .paymentVoucher(command.getPaymentVoucher())
                .amount(command.getAmount())
                .store(command.getStore())
                .finalAmount(finalAmount)
                .storeDiscount(command.getStoreDiscount())
                .cuitStore(command.getCuitStore())
                .build();
    }

    private Set<Discount> findDiscounts(List<String> discountsId) {
        Set<Discount> discounts = new HashSet<>();
        discountsId.forEach(id -> {
            var discount = discountPort.findById(id).get();
            discounts.add(discount);
        });
        return  discounts;
    }

    private float calculateFinalAmount(Set<Discount> discounts, CreatePurchaseCommand command) {
        AtomicReference<Float> amount = new AtomicReference<>(command.getAmount());
        discounts.forEach(discount -> {
            var priceCap = discount.getPriceCap();
            if (priceCap > amount.get()) {
                amount.set(amount.get() - (amount.get() * (discount.getDiscountPercentage() / 100)));
            } else {
                amount.set(amount.get() - (priceCap * (discount.getDiscountPercentage() / 100)));
            }
        });
        return amount.get();
    }

    private Payment parseToPayment(CreatePurchaseCommand command) {
        return Payment.builder()
                .totalPrice(command.getTotalPrice())
                .month(command.getMonth())
                .code(command.getCode())
                .year(command.getYear())
                .build();
    }
}
