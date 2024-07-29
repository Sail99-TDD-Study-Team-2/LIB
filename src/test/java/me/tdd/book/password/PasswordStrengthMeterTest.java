package me.tdd.book.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {

    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    /*
        📌 패스워드 보안 레벨
        1. 길이가 8글자 이상
        2. 0 ~ 9 사이의 숫자를 포함
        3. 대문자 포함

        1개: 약함 / 2개: 보통 / 3개: 강함

        📌 가장 쉬운 or 예외적인 케이스?
        1. 모든 규칙 충족
        2. 모든 규칙 불충족
     */
    @Test
    @DisplayName("비밀번호가 모든 조건 충족")
    void meetsAllCriteriaThenStrong() {
        this.checkPw(PwSecurityLevel.STRONG, "ab12!@AB");
        this.checkPw(PwSecurityLevel.STRONG, "abc1!Add");
    }

    @Test
    @DisplayName("길이8 x")
    void notMeetRequiredPwLength() {
        this.checkPw(PwSecurityLevel.MODERATE, "ab12!@A");
    }

    @Test
    @DisplayName("숫자 x")
    void notContainDigits() {
        this.checkPw(PwSecurityLevel.MODERATE, "ab!@ABqwer");
    }

    @Test
    @DisplayName("Null 이 입력된 경우")
    void ifInputNull() {
        this.checkPw(PwSecurityLevel.INVALID, null);
    }

    @Test
    @DisplayName("빈 값 입력")
    void ifInputBlank() {
        this.checkPw(PwSecurityLevel.INVALID, "");
    }

    @Test
    @DisplayName("대문자 x")
    void notContainsCapitalLetter() {
        this.checkPw(PwSecurityLevel.MODERATE, "ab12!@df");
    }

    @Test
    @DisplayName("길이8 o")
    void meetOnlyLength() {
        this.checkPw(PwSecurityLevel.WEEK, "abdefghi");
    }

    @Test
    @DisplayName("숫자 o")
    void containsADigit() {
        this.checkPw(PwSecurityLevel.WEEK, "123456");
    }

    @Test
    @DisplayName("대문자 o")
    void containCapitalLetter() {
        this.checkPw(PwSecurityLevel.WEEK, "ABCDE");
    }

    @Test
    @DisplayName("아무것도 충족 x")
    void meetNothing() {
        this.checkPw(PwSecurityLevel.WEEK, "abc");
    }

    private void checkPw(PwSecurityLevel level, String pw) {
        assertEquals(level, meter.meter(pw));
    }
}
