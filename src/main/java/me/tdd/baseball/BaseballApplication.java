package me.tdd.baseball;

import me.tdd.baseball.controller.BaseballGame;

import java.io.IOException;

public class BaseballApplication {
    public static void main(String[] args) throws IOException {
        BaseballGame game = new BaseballGame();

        game.playBall();
    }
}
