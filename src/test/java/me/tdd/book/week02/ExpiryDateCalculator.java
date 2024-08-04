package me.tdd.book.week02;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public static final int AMOUNT_PER_A_MONTH = 10_000;

    public LocalDate calcExpiryDate(PayDate payDate) {
        int addedMonth = payDate.getPayAmount() / AMOUNT_PER_A_MONTH;

        if(payDate.getPayFirstDate() != null) {
            return this.expiryDateUsingFirstPayDate(payDate, addedMonth);
        }

        return payDate.getPayDate().plusMonths(addedMonth);
    }

    private LocalDate expiryDateUsingFirstPayDate(PayDate payDate, int addedMonths) {
        LocalDate candidateExp = payDate.getPayDate().plusMonths(addedMonths);
        final int dayOfFirstPayMonth = payDate.getPayFirstDate().getDayOfMonth();

        if(!isSameDayOfMonth(dayOfFirstPayMonth, candidateExp)) {
            final int dayLenOfCandiMon = getLastDayOfMonth(candidateExp);

            if(dayLenOfCandiMon < dayOfFirstPayMonth) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }

            return candidateExp.withDayOfMonth(dayOfFirstPayMonth);
        }

        return candidateExp;
    }

    private int getLastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(int dayOfFirstPayMonth, LocalDate candidateExp) {
        return dayOfFirstPayMonth == candidateExp.getDayOfMonth();
    }
}
