package me.tdd.baseball.stub;

import me.tdd.baseball.RandomNumber;

import java.util.List;

public class StubRandomNumber extends RandomNumber {
    public static List<Integer> getRandomNumbers() {
        return List.of(1, 2, 3);
    }
}
