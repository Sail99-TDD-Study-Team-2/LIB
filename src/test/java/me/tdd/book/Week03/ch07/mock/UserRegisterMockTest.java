package me.tdd.book.Week03.ch07.mock;

import me.tdd.book.Week03.ch07.EmailNotifier;
import me.tdd.book.Week03.ch07.UserRegister;
import me.tdd.book.Week03.ch07.WeakPasswordChecker;
import me.tdd.book.Week03.ch07.exception.WeakPasswordException;
import me.tdd.book.Week03.ch07.repository.MemoryUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterMockTest {

    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository memoryUserRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setup() {
        userRegister = new UserRegister(mockPasswordChecker, memoryUserRepository, mockEmailNotifier);
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    void weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw"))
                  .willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
           userRegister.register("id", "pw", "email");
        });
    }

    @Test
    @DisplayName("회원 가입시 암호 검사 수행함")
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockPasswordChecker)
                  .should()
                  .checkPasswordWeak(BDDMockito.anyString());
    }

    @Test
    @DisplayName("가입하면 메일을 전송함")
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                  .should()
                  .sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email", realEmail);
    }
}
