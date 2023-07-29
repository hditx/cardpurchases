package com.tpdbd.cardpurchases.application.purchase;

import com.tpdbd.cardpurchases.domain.CashPayment;
import com.tpdbd.cardpurchases.domain.Discount;
import com.tpdbd.cardpurchases.domain.Payment;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.repository.CashPaymentRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class CreateCashPurchase {
    private final CashPaymentRepository cashPaymentRepository;
    private final CardRepository cardRepository;
    private final DiscountRepository discountRepository;

    private final PaymentRepository paymentRepository;

    public CreateCashPurchase(CashPaymentRepository cashPaymentRepository, CardRepository cardRepository,
                              DiscountRepository discountRepository, PaymentRepository paymentRepository) {
        this.cashPaymentRepository = cashPaymentRepository;
        this.cardRepository = cardRepository;
        this.discountRepository = discountRepository;
        this.paymentRepository = paymentRepository;
    }

    public void invoke(CreatePurchaseCommand command) {
        Payment payment = parseToPayment(command);
        payment = paymentRepository.save(payment);
        CashPayment cashPayment = parseCommandToCashPayment(command);
        cashPayment.setPaymentId(payment);
        cashPaymentRepository.save(cashPayment);
    }

    private CashPayment parseCommandToCashPayment(CreatePurchaseCommand command) {
        var card = cardRepository.findById(command.getCardId()).get();
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
            var discount = discountRepository.findById(id).get();
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
