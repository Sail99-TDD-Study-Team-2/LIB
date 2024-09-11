package me.tdd.tddpractice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest2 {

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study_fast() {
        Study actual = new Study(100);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_slow() {
        System.out.println("create1");
    }

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void create_study(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} msg={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterizedTest(String msg) {
        System.out.println(msg);
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}