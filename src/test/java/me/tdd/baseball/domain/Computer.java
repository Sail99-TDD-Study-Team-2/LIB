package me.tdd.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    int firstNum;
    int secondNum;
    int thirdNum;

    public Computer() {
        List<Integer> answerNumbers = getAnswerNumbers();

        this.firstNum = answerNumbers.get(0);
        this.secondNum = answerNumbers.get(1);
        this.thirdNum = answerNumbers.get(2);

        System.out.println(String.format("===== Answer: [%d %d %d] =====", firstNum, secondNum, thirdNum));
    }

    public List<Integer> getAnswerNumbers() {
        List<Integer> nums = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(nums);

        return nums.subList(0, 3);
    }
}
