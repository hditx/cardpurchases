package com.tpdbd.cardpurchases.infrastructure.repositories;

import com.tpdbd.cardpurchases.domain.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query(value = """
            SELECT bank.*
            FROM banks bank
            JOIN cards ON bank.id = cards.bank_id
            JOIN (
                SELECT purchases.card_id, SUM(purchases.final_amount) AS totalamount
                FROM purchases
                GROUP BY purchases.card_id
            ) AS cardpurchases ON cards.id = cardpurchases.card_id
            ORDER BY cardpurchases.totalamount DESC
            LIMIT 1
            """)
    Bank findMostPaymentWithCard();
}