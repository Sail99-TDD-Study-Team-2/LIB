package me.tdd.baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumber {
    public static List<Integer> getRandomNumbers() {
        List<Integer> nums = IntStream.range(1, 10)
                                      .boxed()
                                      .collect(Collectors.toList());

        Collections.shuffle(nums);

        return nums.subList(0, 3)
                   .stream()
                   .distinct()
                   .collect(Collectors.toUnmodifiableList());
    }
}
