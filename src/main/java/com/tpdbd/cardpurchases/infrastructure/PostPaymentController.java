package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.payment.CreatePayment;
import com.tpdbd.cardpurchases.application.payment.CreatePaymentCommand;
import com.tpdbd.cardpurchases.domain.repository.MonthlyPaymentsRepository;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.repository.QuotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/payment")
public class PostPaymentController {
    private final CreatePayment createPayment;

    public  PostPaymentController(PaymentRepository paymentRepository, MonthlyPaymentsRepository monthlyPaymentsRepository,
                                  QuotaRepository quotaRepository) {
        this.createPayment = new CreatePayment(paymentRepository, monthlyPaymentsRepository, quotaRepository);
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreatePaymentCommand command) throws ParseException {
        createPayment.invoke(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
