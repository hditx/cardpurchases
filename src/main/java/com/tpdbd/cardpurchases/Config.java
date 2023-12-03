package com.tpdbd.cardpurchases;

import com.tpdbd.cardpurchases.application.ports.*;
import com.tpdbd.cardpurchases.application.usecases.bank.CreateBankUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.bank.FindBankMostPaymentWithCardUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.bank.MostPaymentBankUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.card.CreateCardUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.card.FindExpirationCardUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.cardholder.CreateCardHolderUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.cardholder.FindCardHolderMostPurchaseUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.discount.CreateDiscountUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.financing.CreateFinancingUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.payment.CreatePaymentUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.payment.FindTotalPaymentMonthUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.promotion.DeletePromotionByCodeUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.promotion.ValidPromotionStoreUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.purchase.CreateCashPurchaseUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.purchase.CreateMonthlyPurchaseUseCaseImpl;
import com.tpdbd.cardpurchases.application.usecases.purchase.UpdatePurchaseDateUseCaseImpl;
import com.tpdbd.cardpurchases.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@Profile("mongodb-local")
@EnableMongoRepositories(basePackages = {"com.tpdbd.cardpurchases.infrastructure.repositories"})
@ComponentScan(basePackages = {"com.tpdbd.cardpurchases.infrastructure.repositories"})
public class Config {
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    public FindExpirationCardUseCase getFindExpirationCardUseCase(CardPort cardPort) {
        return new FindExpirationCardUseCaseImpl(cardPort);
    }

    @Bean
    public CreateBankUseCase getCreateBakUseCase(BankPort bankPort) {
        return new CreateBankUseCaseImpl(bankPort);
    }

    @Bean
    public CreateCardHolderUseCase getCreateCardHolderUserCase(CardHolderPort cardHolderPort, BankPort bankPort) {
        return new CreateCardHolderUseCaseImpl(cardHolderPort, bankPort);
    }

    @Bean
    public CreateCardUseCase getCreateCardUseCase(CardPort cardPort, BankPort bankPort,
                                                  CardHolderPort cardHolderPort) {
        return new CreateCardUseCaseImpl(cardPort, bankPort, cardHolderPort);
    }

    @Bean
    public CreateCashPurchaseUseCase getCreateCashPurchaseUseCase(CashPaymentPort cashPaymentPort, CardPort cardPort,
                                                                  DiscountPort discountPort, PaymentPort paymentPort) {
        return new CreateCashPurchaseUseCaseImpl(cashPaymentPort, cardPort, discountPort, paymentPort);
    }

    @Bean
    public CreateDiscountUseCase getCreateDiscountUseCase(DiscountPort discountPort, BankPort bankPort) {
        return new CreateDiscountUseCaseImpl(discountPort, bankPort);
    }

    @Bean
    public CreateFinancingUseCase getCreateFinancingUseCase(FinancingPort financingPort, BankPort bankPort) {
        return new CreateFinancingUseCaseImpl(financingPort, bankPort);
    }

    @Bean
    public CreateMonthlyPurchaseUseCase getCreateMonthlyPurchaseUseCase(MonthlyPaymentPort monthlyPaymentPort, DiscountPort discountPort,
                                                                        FinancingPort financingPort, CardPort cardPort) {
        return new CreateMonthlyPurchaseUseCaseImpl(monthlyPaymentPort, discountPort, financingPort, cardPort);
    }

    @Bean
    public CreatePaymentUseCase getCreatePaymentUseCase(PaymentPort paymentPort, MonthlyPaymentPort monthlyPaymentPort,
                                                        QuotaPort quotaPort) {
        return new CreatePaymentUseCaseImpl(paymentPort, monthlyPaymentPort, quotaPort);
    }

    @Bean
    public FindTotalPaymentMonthUseCase getFindTotalPaymentMonthUseCase(PaymentPort paymentPort) {
        return new FindTotalPaymentMonthUseCaseImpl(paymentPort);
    }

    @Bean
    public MostPaymentBankUseCase getMostPaymentBankUseCase(BankPort bankPort) {
        return new MostPaymentBankUseCaseImpl(bankPort);
    }

    @Bean
    public UpdatePurchaseDateUseCase getUpdatePurchaseDateUseCase(PaymentPort paymentPort) {
        return new UpdatePurchaseDateUseCaseImpl(paymentPort);
    }

    @Bean
    public DeletePromotionByCodeUseCase getDeletePromotionByCodeUseCase(DiscountPort discountPort, FinancingPort financingPort) {
        return new DeletePromotionByCodeUseCaseImpl(discountPort, financingPort);
    }

    @Bean
    public ValidPromotionStoreUseCase getValidPromotionStoreUseCase(DiscountPort discountPort, FinancingPort financingPort) {
        return new ValidPromotionStoreUseCaseImpl(discountPort, financingPort);
    }

    @Bean
    public FindBankMostPaymentWithCardUseCase getFindBankMostPaymentWithCardUseCase(BankPort bankPort) {
        return new FindBankMostPaymentWithCardUseCaseImpl(bankPort);
    }

    @Bean
    public FindCardHolderMostPurchaseUseCase getFindCardHolderMostPurchaseUseCase(CardHolderPort cardHolderPort) {
        return new FindCardHolderMostPurchaseUseCaseImpl(cardHolderPort);
    }
}
