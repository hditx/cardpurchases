package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.purchase.UpdatePurchaseDateUseCaseImpl;
import com.tpdbd.cardpurchases.application.purchase.UpdatePurchaseDateCommand;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.usecase.UpdatePurchaseDateUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/purchase")
public class PutPurchaseController {
    private final UpdatePurchaseDateUseCase updatePurchaseDateUseCaseImpl;

    public PutPurchaseController(PaymentRepository paymentRepository) {
        this.updatePurchaseDateUseCaseImpl = new UpdatePurchaseDateUseCaseImpl(paymentRepository);
    }
    @PutMapping("/update")
    public ResponseEntity<?> invoke(@RequestBody UpdatePurchaseDateCommand command) throws ParseException {
        this.updatePurchaseDateUseCaseImpl.invoke(command);
        return ResponseEntity.ok().build();
    }
}
