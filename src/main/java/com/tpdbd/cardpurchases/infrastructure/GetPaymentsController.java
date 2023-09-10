package com.tpdbd.cardpurchases.infrastructure;

import com.tpdbd.cardpurchases.application.payment.FindTotalPaymentMonthUseCaseImpl;
import com.tpdbd.cardpurchases.domain.repository.PaymentRepository;
import com.tpdbd.cardpurchases.domain.usecase.FindTotalPaymentMonthUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class GetPaymentsController {
    private final FindTotalPaymentMonthUseCase findTotalPaymentMonthUseCaseImpl;

    public GetPaymentsController(PaymentRepository paymentRepository){
        this.findTotalPaymentMonthUseCaseImpl = new FindTotalPaymentMonthUseCaseImpl(paymentRepository);
    }
    @GetMapping("/{month}")
    public ResponseEntity<?> invoke(@PathVariable String month) {
        return ResponseEntity.ok(this.findTotalPaymentMonthUseCaseImpl.invoke(month));
    }
}
