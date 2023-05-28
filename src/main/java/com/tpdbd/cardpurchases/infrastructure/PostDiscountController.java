package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.discount.CreateDiscount;
import com.tpdbd.cardpurchases.application.discount.CreateDiscountCommand;
import com.tpdbd.cardpurchases.domain.repository.BankRepository;
import com.tpdbd.cardpurchases.domain.repository.DiscountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/discount")
public class PostDiscountController {

    private final CreateDiscount createDiscount;

    public PostDiscountController(DiscountRepository discountRepository, BankRepository bankRepository) {
        this.createDiscount = new CreateDiscount(discountRepository, bankRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateDiscountCommand command) throws ParseException {
        createDiscount.invoke(command);
        return ResponseEntity.ok().build();
    }
}
