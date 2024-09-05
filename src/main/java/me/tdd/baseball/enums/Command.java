package me.tdd.baseball.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Command {
    NEW_GAME("1", "컴퓨터가 숫자를 뽑았습니다."),
    EXIT("9", "애플리케이션이 종료되었습니다.")
    ;

    private String command;
    private String comment;
    public static final Map<String, Command> COMMAND_MAP;

    Command(String command, String comment) {
        this.command = command;
        this.comment = comment;
    }

    public String getCommand() {
        return command;
    }

    public String getComment() {
        return comment;
    }

    static {
        Map<String, Command> temp = new HashMap<>();

        for(Command command : values()) {
            temp.put(command.getCommand(), command);
        }

        COMMAND_MAP = Collections.unmodifiableMap(temp);
    }
}
