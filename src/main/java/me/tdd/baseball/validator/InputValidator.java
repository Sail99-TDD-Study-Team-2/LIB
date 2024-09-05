package me.tdd.baseball.validator;

public class InputValidator {

    public static final int MAX_LENGTH = 3;

    private InputValidator() {}

    public static boolean isNumeric(final String nums) {
        return nums.chars()
                   .filter(Character::isDigit)
                   .count() == MAX_LENGTH;
    }

    public static boolean isValidLength(final String nums) {
        return nums.chars()
                   .distinct()
                   .count() == MAX_LENGTH;
    }
}
