package com.tpdbd.cardpurchases.application.usecases.promotion;

import com.tpdbd.cardpurchases.application.ports.DiscountPort;
import com.tpdbd.cardpurchases.application.ports.FinancingPort;
import com.tpdbd.cardpurchases.domain.usecases.DeletePromotionByCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class DeletePromotionByCodeUseCaseImpl implements DeletePromotionByCodeUseCase {

    private final DiscountPort discountPort;
    private final FinancingPort financingPort;

    @Transactional
    @Override
    public void invoke(String code) {
        var discount = discountPort.findByCode(code);
        var financing = financingPort.findByCode(code);
        discount.ifPresent(discountPort::delete);
        financing.ifPresent(financingPort::delete);
    }
}
