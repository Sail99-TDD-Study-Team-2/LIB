package me.tdd.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    final int firstNum;
    final int secondNum;
    final int thirdNum;
    final List<Integer> answerNumbers;

    private Computer() {
        this.answerNumbers = setAnswerNumbers();
        this.firstNum = answerNumbers.get(0);
        this.secondNum = answerNumbers.get(1);
        this.thirdNum = answerNumbers.get(2);

        System.out.println(String.format("===== Answer: [%d %d %d] =====", firstNum, secondNum, thirdNum));
    }

    public static Computer of() {
        return new Computer();
    }

    public List<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }

    private List<Integer> setAnswerNumbers() {
        List<Integer> nums = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(nums);

        return Collections.unmodifiableList(nums.subList(0, 3));
    }
}
