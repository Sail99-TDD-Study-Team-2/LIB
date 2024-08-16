package me.tdd.book.Week03.ch07.stub;

import me.tdd.book.Week03.ch07.WeakPasswordChecker;

public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
