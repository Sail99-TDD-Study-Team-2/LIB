package me.tdd.book.Week03.test;

import me.tdd.book.Week03.AutoDebitRegister;
import me.tdd.book.Week03.AutoDebitReq;
import me.tdd.book.Week03.RegisterResult;
import me.tdd.book.Week03.stub.StubAutoDebitInfoRepository;
import me.tdd.book.Week03.stub.StubCardNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.tdd.book.Week03.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepo;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepo = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepo);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }
}
