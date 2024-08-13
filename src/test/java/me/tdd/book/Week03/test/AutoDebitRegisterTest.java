package me.tdd.book.Week03.test;

import me.tdd.book.Week03.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.tdd.book.Week03.CardValidity.THEFT;
import static me.tdd.book.Week03.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegisterTest {

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repo = new JpaAutoDebitInfoRepository();

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
