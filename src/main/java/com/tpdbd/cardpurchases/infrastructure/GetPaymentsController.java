package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.payment.FindTotalPaymentMonth;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class GetPaymentsController {
    private final FindTotalPaymentMonth findTotalPaymentMonth;

    public GetPaymentsController(PaymentRepository paymentRepository){
        this.findTotalPaymentMonth = new FindTotalPaymentMonth(paymentRepository);
    }
    @GetMapping("/{month}")
    public ResponseEntity<?> invoke(@PathVariable String month) {
        return ResponseEntity.ok(this.findTotalPaymentMonth.invoke(month));
    }
}
