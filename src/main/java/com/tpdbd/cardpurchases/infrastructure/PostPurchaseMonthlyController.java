package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.purchase.CreateMonthlyPurchaseUseCaseImpl;
import com.tpdbd.cardpurchases.application.purchase.CreatePurchaseCommand;
import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;
import com.tpdbd.cardpurchases.domain.repository.FinancingRepository;
import com.tpdbd.cardpurchases.domain.repository.MonthlyPaymentsRepository;
import com.tpdbd.cardpurchases.domain.usecase.CreateMonthlyPurchaseUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase/monthly")
public class PostPurchaseMonthlyController {

    private final CreateMonthlyPurchaseUseCase monthlyPurchase;
    public PostPurchaseMonthlyController(MonthlyPaymentsRepository monthlyPaymentsRepository, DiscountRepository discountRepository,
                                         FinancingRepository financingRepository, CardRepository cardRepository) {
        this.monthlyPurchase = new CreateMonthlyPurchaseUseCaseImpl(monthlyPaymentsRepository, discountRepository,
                financingRepository, cardRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePurchaseCommand command) {
        monthlyPurchase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
