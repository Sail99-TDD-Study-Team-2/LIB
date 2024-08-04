package me.tdd.book.week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 📌 테스트 목표
 * ⌙ 서비스를 사용하려면 매달 1만 원을 선불로 납부한다.
 * ⌙ 납부일 기준으로 한 달 뒤가 서비스 만료일이 된다.
 * ⌙ 2개월 이상 요금을 납부할 수 있다.
 * ⌙ 10만 원을 납부하면 서비스를 1년 제공한다.
 */
public class ExpiryDateCalculatorTest {

    @Test
    void 만원은_한_달_만료() {
        int paidAmount = 10_000;

        assertExpiryDate(
                LocalDate.of(2024, 7, 1),
                paidAmount,
                LocalDate.of(2024, 8, 1)
        );

        assertExpiryDate(
                LocalDate.of(2024, 5, 5),
                paidAmount,
                LocalDate.of(2024, 6, 5)
        );

        assertExpiryDate(
                LocalDate.of(2023,1,31),
                paidAmount,
                LocalDate.of(2023,2,28)
        );

        assertExpiryDate(
                LocalDate.of(2023,5,31),
                paidAmount,
                LocalDate.of(2023,6,30)
        );

        assertExpiryDate(
                LocalDate.of(2024,1,31),
                paidAmount,
                LocalDate.of(2024,2,29)
        );
    }

    private void assertExpiryDate(LocalDate expiryDate, int amount, LocalDate expectedDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate calcDate = cal.calcExpiryDate(expiryDate, amount);

        assertEquals(expectedDate, calcDate);
    }
}
