package me.tdd.book.Week03.ch07.test;

import me.tdd.book.Week03.ch07.spy.SpyEmailNotifier;
import me.tdd.book.Week03.ch07.stub.StubWeakPasswordChecker;
import me.tdd.book.Week03.ch07.UserRegister;
import me.tdd.book.Week03.ch07.entity.User;
import me.tdd.book.Week03.ch07.exception.DupIdException;
import me.tdd.book.Week03.ch07.exception.WeakPasswordException;
import me.tdd.book.Week03.ch07.repository.MemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepo = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setup() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepo, spyEmailNotifier);
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    void weakPassword() {
        stubWeakPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () -> {
           userRegister.register("id", "pw", "email");
        });
    }

    @Test
    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    void dupIdExists() {
        fakeRepo.save(new User("id", "pw1", "email@email.com"));

        assertThrows(DupIdException.class, () -> {
           userRegister.register("id", "pw2", "email@email.kr");
        });
    }

    @Test
    @DisplayName("가입하면 메일을 전송함")
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com", spyEmailNotifier.getEmail());
    }
}
