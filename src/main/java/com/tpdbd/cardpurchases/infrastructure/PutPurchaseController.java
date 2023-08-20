package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.purchase.UpdatePurchaseDate;
import com.tpdbd.cardpurchases.application.purchase.UpdatePurchaseDateCommand;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/purchase")
public class PutPurchaseController {
    private final UpdatePurchaseDate updatePurchaseDate;

    public PutPurchaseController(PaymentRepository paymentRepository) {
        this.updatePurchaseDate = new UpdatePurchaseDate(paymentRepository);
    }
    @PutMapping("/update")
    public ResponseEntity<?> invoke(@RequestBody UpdatePurchaseDateCommand command) throws ParseException {
        this.updatePurchaseDate.invoke(command);
        return ResponseEntity.ok().build();
    }
}
