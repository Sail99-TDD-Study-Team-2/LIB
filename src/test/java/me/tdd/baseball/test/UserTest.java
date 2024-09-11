package me.tdd.baseball.test;

import me.tdd.baseball.User;
import me.tdd.baseball.stub.StubRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private final List<Integer> randomNumbers;

    public UserTest() {
        this.randomNumbers = StubRandomNumber.getRandomNumbers();
    }

    @Test
    @DisplayName("3 스트라이크")
    void onlyStrikeCount() {
        User user = User.of("123", randomNumbers);

        assertAll(
                () -> assertEquals(user.getStrikeCnt(), 3),
                () -> assertEquals(user.getBallCnt(), 0)
        );
    }

    @Test
    @DisplayName("OUT")
    void isNotCount() {
        User user = User.of("456", randomNumbers);

        assertAll(
                () -> assertEquals(user.getStrikeCnt(), 0),
                () -> assertEquals(user.getBallCnt(), 0)
        );
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void onlyBallCount() {
        User user = User.of("312", randomNumbers);

        System.out.println(user.getStrikeCnt());
        System.out.println(user.getBallCnt());

        assertAll(
                () -> assertEquals(user.getStrikeCnt(), 0),
                () -> assertEquals(user.getBallCnt(), 3)
        );
    }

    @Test
    @DisplayName("스트라이크 3개 미만")
    void onlyStrikeCountUnderThree() {
        User user = User.of("189", randomNumbers);

        assertAll(
                () -> assertEquals(user.getStrikeCnt(), 1),
                () -> assertEquals(user.getBallCnt(), 0)
        );
    }

    @Test
    @DisplayName("볼 스트라이크 섞인 경우")
    void mixedStrikeAndBallCount() {
        User user = User.of("132", randomNumbers);

        assertAll(
                () -> assertEquals(user.getStrikeCnt(), 1),
                () -> assertEquals(user.getBallCnt(), 2)
        );
    }
}
