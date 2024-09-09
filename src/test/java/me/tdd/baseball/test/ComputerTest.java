package me.tdd.baseball.test;

import me.tdd.baseball.RandomNumber;
import me.tdd.baseball.StubRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    private final int MAX_SIZE = 3;
    private final List<Integer> shuffledNums;

    public ComputerTest() {
        shuffledNums = RandomNumber.getRandomNumbers();
    }

    @Test
    @DisplayName("임의의 서로 다른 수 3개인가")
    void isDifferentNumbers() {
        assertEquals(shuffledNums.size(), MAX_SIZE);
    }

    @Test
    @DisplayName("선정된 숫자가 1 ~ 9 사이의 값인가")
    void isBetweenZeroToNine() {
        assertEquals(IntStream.range(1, 10).count(), 9);
        assertEquals(shuffledNums.stream()
                                 .filter(e -> 0 < e && e < 10)
                                 .count(), MAX_SIZE);
    }

    @Test
    @DisplayName("랜덤한 값인가")
    void isRandomNumbers() {
        List<Integer> randomNumbers = StubRandomNumber.getRandomNumbers();

        assertAll(
                () -> assertEquals(randomNumbers.size(), MAX_SIZE),
                () -> assertTrue(randomNumbers.contains(1)),
                () -> assertTrue(randomNumbers.contains(2)),
                () -> assertTrue(randomNumbers.contains(3))
        );
    }
}
