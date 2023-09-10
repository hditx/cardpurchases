package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.purchase.CreateCashPurchaseUseCaseImpl;
import com.tpdbd.cardpurchases.application.purchase.CreatePurchaseCommand;

import com.tpdbd.cardpurchases.domain.repository.CardRepository;
import com.tpdbd.cardpurchases.domain.repository.CashPaymentRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.usecase.CreateCashPurchaseUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase/cash")
public class PostPurchaseCashController {

    private final CreateCashPurchaseUseCase createCashPurchaseUseCaseImpl;
    public PostPurchaseCashController(CashPaymentRepository cashPaymentRepository, CardRepository cardRepository,
                                      DiscountRepository discountRepository, PaymentRepository paymentRepository) {
        this.createCashPurchaseUseCaseImpl = new CreateCashPurchaseUseCaseImpl(cashPaymentRepository, cardRepository, discountRepository, paymentRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePurchaseCommand command) {
        createCashPurchaseUseCaseImpl.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
