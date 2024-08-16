package me.tdd.book.Week03.ch06.test;

import me.tdd.book.Week03.ch06.*;
import me.tdd.book.Week03.ch06.stub.MemoryAutoDebitInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.tdd.book.Week03.ch06.CardValidity.THEFT;
import static me.tdd.book.Week03.ch06.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegisterTest {

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repo = new MemoryAutoDebitInfoRepository();

        register = new AutoDebitRegister(validator, repo);
    }

    @Test
    void validCard() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);

        assertEquals(THEFT, result.getValidity());
    }
}
