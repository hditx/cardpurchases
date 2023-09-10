package com.tpdbd.cardpurchases.application.purchase;

import com.tpdbd.cardpurchases.domain.Discount;
import com.tpdbd.cardpurchases.domain.Financing;
import com.tpdbd.cardpurchases.domain.MonthlyPayments;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;
import com.tpdbd.cardpurchases.domain.repository.FinancingRepository;
import com.tpdbd.cardpurchases.domain.repository.MonthlyPaymentsRepository;
import com.tpdbd.cardpurchases.domain.usecase.CreateMonthlyPurchaseUseCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class CreateMonthlyPurchaseUseCaseImpl implements CreateMonthlyPurchaseUseCase {
    private final MonthlyPaymentsRepository monthlyPaymentsRepository;
    private final DiscountRepository discountRepository;
    private final FinancingRepository financingRepository;
    private final CardRepository cardRepository;

    public CreateMonthlyPurchaseUseCaseImpl(MonthlyPaymentsRepository monthlyPaymentsRepository, DiscountRepository discountRepository,
                                            FinancingRepository financingRepository, CardRepository cardRepository) {
        this.monthlyPaymentsRepository = monthlyPaymentsRepository;
        this.discountRepository = discountRepository;
        this.financingRepository = financingRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void invoke(CreatePurchaseCommand command) {
        MonthlyPayments monthlyPayments = parseCommandToMonthly(command);
        monthlyPaymentsRepository.save(monthlyPayments);
    }
    private MonthlyPayments parseCommandToMonthly(CreatePurchaseCommand command) {
        var card = cardRepository.findById(command.getCardId()).get();
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
            var discount = discountRepository.findById(id).get();
            discounts.add(discount);
        });
        return  discounts;
    }

    private Set<Financing> findFinancing(List<String> financingsId) {
        Set<Financing> financings = new HashSet<>();
        financingsId.forEach(id -> {
            var financing = financingRepository.findById(id).get();
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
                    amount.set(amount.get() + (amount.get() * financing.getInteres()));
                });
        return amount.get();
    }
}
