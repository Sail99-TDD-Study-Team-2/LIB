package me.tdd.book.Week03.ch07.spy;

import me.tdd.book.Week03.ch07.EmailNotifier;

public class SpyEmailNotifier implements EmailNotifier {

    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void sendRegisterEmail(String email) {
        this.email = email;
        this.called = true;
    }
}
