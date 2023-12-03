package com.tpdbd.cardpurchases.application.usecases.purchase;

import com.tpdbd.cardpurchases.application.ports.CardPort;
import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.application.ports.MonthlyPaymentPort;
import com.tpdbd.cardpurchases.domain.entities.Discount;
import com.tpdbd.cardpurchases.domain.entities.Financing;
import com.tpdbd.cardpurchases.domain.entities.MonthlyPayments;
import com.tpdbd.cardpurchases.domain.entities.Promotion;
import com.tpdbd.cardpurchases.domain.usecases.CreateMonthlyPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class CreateMonthlyPurchaseUseCaseImpl implements CreateMonthlyPurchaseUseCase {
    private final MonthlyPaymentPort monthlyPaymentPort;
    private final DiscountPort discountPort;
    private final FinancingPort financingPort;
    private final CardPort cardPort;

    @Transactional
    @Override
    public void invoke(CreatePurchaseCommand command) {
        MonthlyPayments monthlyPayments = parseCommandToMonthly(command);
        monthlyPaymentPort.save(monthlyPayments);
    }
    private MonthlyPayments parseCommandToMonthly(CreatePurchaseCommand command) {
        var card = cardPort.findById(command.getCardId()).get();
        var discounts = findDiscounts(command.getDiscountsId());
        var financings = findFinancing(command.getFinancingsId());
        float finalAmount = calculateFinalAmount(discounts, financings, command);
        return MonthlyPayments
                .builder()
                .cardId(card)
                .amount(command.getAmount())
                .finalAmount(finalAmount)
                .store(command.getStore())
                .cuitStore(command.getCuitStore())
                .discountsId(discounts)
                .financingsId(financings)
                .interest(command.getInterest())
                .numberOfQuotas(command.getNumberOfQuotas())
                .paymentVoucher(command.getPaymentVoucher())
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

    private Set<Financing> findFinancing(List<String> financingsId) {
        Set<Financing> financings = new HashSet<>();
        financingsId.forEach(id -> {
            var financing = financingPort.findById(id).get();
            financings.add(financing);
        });
        return  financings;
    }

    private float calculateFinalAmount(Set<Discount> discounts, Set<Financing> financings, CreatePurchaseCommand command) {
        AtomicReference<Float> amount = new AtomicReference<>(command.getAmount());
        discounts
                .stream()
                .filter(discount -> !discount.isOnlyCash())
                .forEach(discount -> {
            var priceCap = discount.getPriceCap();
            if (priceCap > amount.get()) {
                amount.set(amount.get() - (amount.get() * (discount.getDiscountPercentage() / 100)));
            } else {
                amount.set(amount.get() - (priceCap * (discount.getDiscountPercentage() / 100)));
            }
        });
        financings
                .stream()
                .filter(financing -> financing.getNumberOfQuotas() == command.getNumberOfQuotas())
                .forEach(financing -> {
                    amount.set(amount.get() + (amount.get() * financing.getInterest()));
                });
        return amount.get();
    }
}
