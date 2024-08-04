package me.tdd.book.week02;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calcExpiryDate(PayDate payDate) {
        return payDate.getPayDate().plusMonths(1);
    }
}
