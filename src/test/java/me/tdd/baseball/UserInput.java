package me.tdd.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private final String input;

    public UserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
    }

    public String getUserInput() {
        return input;
    }
}
