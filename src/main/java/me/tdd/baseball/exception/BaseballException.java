package me.tdd.baseball.exception;

import me.tdd.baseball.controller.BaseballGame;

public class BaseballException extends RuntimeException {

    public BaseballException(String msg) {
        super(msg);
    }

    public static BaseballException of(String msg) {
        return new BaseballException(msg);
    }
}
