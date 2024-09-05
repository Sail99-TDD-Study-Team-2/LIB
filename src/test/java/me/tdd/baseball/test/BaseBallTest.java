package me.tdd.baseball.test;

import me.tdd.baseball.domain.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

    @Test
    void 랜덤한_3개의_숫자_생성() {
        Assertions.assertEquals(new Computer().getAnswerNumbers().size(), 3);
    }
}
