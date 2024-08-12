package me.tdd.book.week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("10,000원은 한 달 뒤에 만료 케이스")
    void test1() {
        int paidAmount = 10_000;

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2024, 7, 1))
                       .payAmount(paidAmount)
                       .build(),
                LocalDate.of(2024, 8, 1)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2024, 5, 5))
                       .payAmount(paidAmount)
                       .build(),
                LocalDate.of(2024, 6, 5)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2023,1,31))
                       .payAmount(paidAmount)
                       .build(),
                LocalDate.of(2023,2,28)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2023,5,31))
                       .payAmount(paidAmount)
                       .build(),
                LocalDate.of(2023,6,30)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2024,1,31))
                       .payAmount(paidAmount)
                       .build(),
                LocalDate.of(2024,2,29)
        );
    }

    @Test
    @DisplayName("만료일이 불일치 하는 케이스")
    void test2() {
        assertExpiryDate(
                PayDate.builder()
                        .payDate(LocalDate.of(2019,1,31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019,2,28)
        );
    }

    @Test
    @DisplayName("첫 납부일과 만료일 일자가 다를 때 만원을 납부한 케이스")
    void test3() {
        PayDate payDate = PayDate.builder()
                                 .payFirstDate(LocalDate.of(2019,1,31))
                                 .payDate(LocalDate.of(2019,2,28))
                                 .payAmount(10_000)
                                 .build();

        PayDate payDate1 = PayDate.builder()
                                  .payFirstDate(LocalDate.of(2019,1,30))
                                  .payDate(LocalDate.of(2019,2,28))
                                  .payAmount(10_000)
                                  .build();

        assertExpiryDate(payDate, LocalDate.of(2019,3,31));
        assertExpiryDate(payDate1, LocalDate.of(2019,3,30));
    }

    @Test
    @DisplayName("20,000원 이상 납부 케이스")
    void test4() {
        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2019,3,1))
                       .payAmount(20_000)
                       .build(),
                LocalDate.of(2019,5,1)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payDate(LocalDate.of(2019,3,1))
                       .payAmount(30_000)
                       .build(),
                LocalDate.of(2019,6,1)
        );
    }

    @Test
    @DisplayName("첫 납부일과 만료일 일자가 다를 때 20,000원 이상 납부 케이스")
    void test5() {
        assertExpiryDate(
                PayDate.builder()
                       .payFirstDate(LocalDate.of(2019,1,31))
                       .payDate(LocalDate.of(2019,2,28))
                       .payAmount(20_000)
                       .build(),
                LocalDate.of(2019,4,30)
        );

        assertExpiryDate(
                PayDate.builder()
                       .payFirstDate(LocalDate.of(2019,3,31))
                       .payDate(LocalDate.of(2019,4,30))
                       .payAmount(30_000)
                       .build(),
                LocalDate.of(2019,7,31)
        );

        /*assertExpiryDate(
                PayDate.builder()
                       .payFirstDate(LocalDate.of(2019,2,28))
                       .payDate(LocalDate.of(2019,3,31))
                       .payAmount(40_000)
                       .build(),
                LocalDate.of(2019,7,31)
        );*/
    }

    @Test
    @DisplayName("10개월 요금 납부시 1년 요금제 제공")
    public void test6() {
        assertExpiryDate(
                PayDate.builder()
                        .payDate(LocalDate.of(2019,1,28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020,1,28)
        );
    }

    private void assertExpiryDate(PayDate payDate, LocalDate expectedDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate calcDate = cal.calcExpiryDate(payDate);

        assertEquals(expectedDate, calcDate);
    }
}
