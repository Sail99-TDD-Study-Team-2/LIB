package me.tdd.baseball.validator;

import me.tdd.baseball.enums.Command;
import me.tdd.baseball.exception.BaseballException;

import static me.tdd.baseball.enums.Command.COMMAND_MAP;
import static me.tdd.baseball.enums.ExceptionMsg.ILLEGAL_ARGUMENT_COMMAND;

public class CommandValidator {

    private CommandValidator() {}

    public static void continueGame(final String command) {
        if(isNotValid(command)) {
            throw BaseballException.of(ILLEGAL_ARGUMENT_COMMAND.getMsg());
        }

        Command comm = COMMAND_MAP.get(command);
        System.out.print(comm.getComment());

        switch(comm) {
            case NEW_GAME -> { return; }
            case EXIT -> System.exit(0);
        }
    }

    public static boolean isNotValid(final String command) {
        return !COMMAND_MAP.containsKey(command);
    }
}
