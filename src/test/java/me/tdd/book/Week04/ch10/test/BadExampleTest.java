package me.tdd.book.Week04.ch10.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BadExampleTest {

    @Test
    @DisplayName("기대 값을 변수를 이용해서 구성")
    void test1() {
        LocalDate date = LocalDate.of(1945,8,15);
        String dateStr = formatDate(date);

        assertEquals(date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일", dateStr);
    }

    @Test
    @DisplayName("기대 값을 문자열을 사용")
    void test2() {
        LocalDate date = LocalDate.of(1945,8,15);
        String dateStr = formatDate(date);

        assertEquals("1945년 8월 15일", dateStr);
    }

    private String formatDate(LocalDate date) {
        StringBuilder sb = new StringBuilder();

        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());

        return sb.append(date.getYear() + "년 ")
                 .append(date.getMonthValue() + "월 ")
                 .append(date.getDayOfMonth() + "일").
                 toString();
    }
}
