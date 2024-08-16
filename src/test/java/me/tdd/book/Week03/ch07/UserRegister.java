package me.tdd.book.Week03.ch07;

import me.tdd.book.Week03.ch07.entity.User;
import me.tdd.book.Week03.ch07.exception.DupIdException;
import me.tdd.book.Week03.ch07.exception.WeakPasswordException;
import me.tdd.book.Week03.ch07.repository.MemoryUserRepository;
import me.tdd.book.Week03.ch07.spy.SpyEmailNotifier;

public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private MemoryUserRepository userRepository;
    private SpyEmailNotifier spyEmailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, MemoryUserRepository userRepository, SpyEmailNotifier spyEmailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.spyEmailNotifier = spyEmailNotifier;
    }

    public void register(String id, String pw, String email) {
        if(passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        User user = userRepository.findById(id);

        if(user != null) {
            throw new DupIdException();
        }

        userRepository.save(new User(id, pw, email));
        spyEmailNotifier.sendRegisterEmail(email);
    }
}
