package me.tdd.book.calcurator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    /*
        어떤 고민이 필요?
        1. 클래스, 메소드 이름은?
        2. 파라미터, 반환 타입
        3. 정적 메소드, 인스턴스 메소드
     */
    @Test
    void plusTest() {
        assertEquals(3, Calculator.plus(1, 2));
        assertEquals(5, Calculator.plus(4, 1));
    }
}
