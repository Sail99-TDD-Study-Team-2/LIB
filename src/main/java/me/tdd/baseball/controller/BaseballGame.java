package me.tdd.baseball.controller;

import me.tdd.baseball.domain.Computer;
import me.tdd.baseball.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static me.tdd.baseball.validator.CommandValidator.continueGame;

public class BaseballGame {
    final Computer com;

    public BaseballGame() {
        this.com = Computer.of();
    }

    public void playBall() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                // ConsoleMsg.REQUEST
                String command = br.readLine();

                continueGame(command);

                User user = User.of(br.readLine(), this.com.getAnswerNumbers());

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while(true);
    }
}
