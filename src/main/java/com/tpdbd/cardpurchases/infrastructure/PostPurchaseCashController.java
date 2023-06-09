package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.purchase.CreateCashPurchase;
import com.tpdbd.cardpurchases.application.purchase.CreatePurchaseCommand;
import com.tpdbd.cardpurchases.domain.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase/cash")
public class PostPurchaseCashController {

    private final CreateCashPurchase createCashPurchase;
    public PostPurchaseCashController(CashPaymentRepository cashPaymentRepository, CardRepository cardRepository,
                                      DiscountRepository discountRepository, PaymentRepository paymentRepository) {
        this.createCashPurchase = new CreateCashPurchase(cashPaymentRepository, cardRepository, discountRepository, paymentRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePurchaseCommand command) {
        createCashPurchase.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
