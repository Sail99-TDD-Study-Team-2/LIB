package me.tdd.baseball.enums;

public enum ConsoleMsg {
    REQUEST("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.\n"),
    COMPUTER_START("컴퓨터가 숫자를 뽑았습니다.\n"),
    USER_TYPE("숫자를 입력해주세요: "),

    ;

    private final String msg;

    ConsoleMsg(String msg) {
        this.msg = msg;
    }

    public void print() {
        System.out.print(msg);
    }
}
