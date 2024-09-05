package me.tdd.baseball.enums;

public enum ExceptionMsg {
    ILLEGAL_ARGUMENT_COMMAND("해당 명령어는 존재하지 않습니다.\n"),
    ILLEGAL_ARGUMENT_NUMBER("잘못된 숫자를 뽑았습니다.\n")
    ;

    private String msg;

    ExceptionMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
