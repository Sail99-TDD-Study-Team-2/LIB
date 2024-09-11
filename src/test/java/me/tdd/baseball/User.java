package me.tdd.baseball;

import me.tdd.baseball.exception.BaseballException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static me.tdd.baseball.enums.ExceptionMsg.ILLEGAL_ARGUMENT_NUMBER;
import static me.tdd.baseball.validator.InputValidator.*;

public class User {

    private final long ballCnt;
    private final long strikeCnt;

    private User(final long ballCnt, final long strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public static User of(final String nums, final List<Integer> answer) throws BaseballException {
        if(!isNumeric(nums) || !isValidLength(nums)) {
            throw BaseballException.of(ILLEGAL_ARGUMENT_NUMBER.getMsg());
        }

        long strikeCnt = getStrikeCnt(nums, answer);

        return new User(
                getBallCnt(nums, answer) - strikeCnt,
                strikeCnt
        );
    }

    private static long getBallCnt(final String nums, final List<Integer> answer) {
        return Arrays.stream(nums.split(""))
                     .mapToInt(Integer::parseInt)
                     .filter(e -> answer.contains(e))
                     .count();
    }

    private static long getStrikeCnt(final String nums, final List<Integer> answer) {
        List<Integer> numsList = Arrays.stream(nums.split(""))
                                       .mapToInt(Integer::parseInt)
                                       .boxed()
                                       .collect(Collectors.toList());
        long matchCnt = 0;

        for(int i = 0; i < MAX_LENGTH; i++) {
            if(numsList.get(i) == answer.get(i)) {
                matchCnt++;
            }
        }

        return matchCnt;
    }

    public long getBallCnt() {
        return ballCnt;
    }

    public long getStrikeCnt() {
        return strikeCnt;
    }
}