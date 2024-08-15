package me.tdd.book.Week03.ch06.test;

import me.tdd.book.Week03.ch06.AutoDebitInfo;
import me.tdd.book.Week03.ch06.AutoDebitRegister;
import me.tdd.book.Week03.ch06.AutoDebitReq;
import me.tdd.book.Week03.ch06.stub.MemoryAutoDebitInfoRepository;
import me.tdd.book.Week03.ch06.stub.StubCardNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("메모리 DB 대역 클래스 이용한 테스트")
public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator validator;
    private MemoryAutoDebitInfoRepository repo;

    @BeforeEach
    void setup() {
        validator = new StubCardNumberValidator();
        repo = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repo);

        repo.clear();
    }

    @Test
    @DisplayName("이미 등록된 카드인 경우 정보가 변경 되는지")
    void alreadyRegistered_InfoUpdated() {
        repo.save(
                new AutoDebitInfo("user1", "111222333444", LocalDateTime.now())
        );

        AutoDebitReq req = new AutoDebitReq("user1", "123456789012");
        this.register.register(req);

        AutoDebitInfo saved = repo.findOne("user1");

        assertEquals("123456789012", saved.getCardNumber());
    }

    @Test
    @DisplayName("아직 정보가 등록되어 있지 않을 때 새로운 정보가 올바르게 등록 되는지")
    void notYetRegistered_newInfoRegistered() {
        AutoDebitReq req = new AutoDebitReq("user1", "123412341234");
        this.register.register(req);

        AutoDebitInfo saved = repo.findOne("user1");
        assertEquals("123412341234", saved.getCardNumber());
    }
}
