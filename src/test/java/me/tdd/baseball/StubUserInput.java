package me.tdd.baseball;

import java.io.IOException;

public class StubUserInput extends UserInput{
    public StubUserInput() throws IOException {}

    public String getUserInput() {
        return "123";
    }
}
