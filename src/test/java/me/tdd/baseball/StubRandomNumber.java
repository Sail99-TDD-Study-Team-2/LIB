package me.tdd.baseball;

import java.util.List;

public class StubRandomNumber extends RandomNumber{
    public static List<Integer> getRandomNumbers() {
        return List.of(1, 2, 3);
    }
}
