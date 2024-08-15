package me.tdd.book.Week03.ch06.test;

import me.tdd.book.Week03.ch06.AutoDebitRegister;
import me.tdd.book.Week03.ch06.AutoDebitReq;
import me.tdd.book.Week03.ch06.RegisterResult;
import me.tdd.book.Week03.ch06.stub.MemoryAutoDebitInfoRepository;
import me.tdd.book.Week03.ch06.stub.StubCardNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.tdd.book.Week03.ch06.CardValidity.INVALID;
import static me.tdd.book.Week03.ch06.CardValidity.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Stub 을 이용한 카드 유효성 검사")
public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private MemoryAutoDebitInfoRepository stubRepo;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepo = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepo);
    }

    @Test
    @DisplayName("유효 하지 않은 카드 검사")
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    @DisplayName("도난 카드 검사")
    void theftCard() {
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = register.register(req);

        assertEquals(THEFT, result.getValidity());
    }
}
