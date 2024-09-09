package me.tdd.baseball.test;

import me.tdd.baseball.StubUserInput;
import me.tdd.baseball.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    private final int MAX_SIZE = 3;
    private final int ZERO = 48;
    private final int TEN = 58;

    private final UserInput userInput;
    private final String input;

    public InputTest() throws IOException {
        userInput = new StubUserInput();
        input = userInput.getUserInput();
    }

    @Test
    @DisplayName("세 글자 입력")
    void isThreeNumber() {
        assertEquals(input.length(), MAX_SIZE);
    }

    @Test
    @DisplayName("숫자만 입력")
    void isAllDigits() {
        assertEquals(
                getStringToCharArr(input).filter(Character::isDigit).count(),
                MAX_SIZE
        );
    }

    @Test
    @DisplayName("중복 없는 숫자 입력")
    void isNoDistinctNumbers() {
        assertEquals(
                getStringToCharArr(input).distinct().count(),
                MAX_SIZE
        );
    }

    @Test
    @DisplayName("1 ~ 9 범위의 숫자 입력")
    void isAllNumbersInValidRange() {
        assertEquals(
                getStringToCharArr(input).mapToInt(e -> (int) e).filter(e -> ZERO < e && e < TEN).count(),
                MAX_SIZE
        );
    }

    private Stream<Character> getStringToCharArr(String input) {
        return Arrays.stream(input.chars()
                                  .mapToObj(e -> (char) e)
                                  .toArray(Character[]::new));
    }
}
