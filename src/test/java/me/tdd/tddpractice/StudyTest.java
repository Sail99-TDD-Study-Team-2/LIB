package me.tdd.tddpractice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class StudyTest {

    @Test
    @DisplayName("ヽ(^。^)丿 스터디 만들기")
    @Tag("fast")
    void create_new_study() {
        Study study = new Study(-1);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디 생성시 초기 상태 값 DRAFT"),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능은 인원은 0보다 커야 한다.")
        );
    }

    @Test
    @DisplayName("(°͈̅\u200B ᢐ °͈̅) 스터디 만들기")
    @Tag("slow")
    // @Disabled
    void create_new_study_again() {
        IllegalArgumentException except = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("Limit must be a positive number", except.getMessage());
    }

    @Test
    @DisplayName("(⸝⸝ᵕᴗᵕ⸝⸝) 스터디 만들기")
    void createNewStudyTimeOut() {
        // 별도의 스레드(ThreadLocal)에서 테스트 진행 하게됨
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_21})
    void env() {
        String env = System.getenv("TEST_ENV");

        // assumeTrue("LOCAL".equalsIgnoreCase(env));

        assumingThat("LOCAL".equalsIgnoreCase(env), () -> {
            // local 일 때
        });

        assumingThat("PROD".equalsIgnoreCase(env), () -> {
            // prod 일 때
        });
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