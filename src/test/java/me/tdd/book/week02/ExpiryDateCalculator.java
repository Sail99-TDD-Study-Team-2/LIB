package me.tdd.book.week02;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calcExpiryDate(LocalDate paidDate, int paidAmount) {
        return paidDate.plusMonths(1);
    }
}
