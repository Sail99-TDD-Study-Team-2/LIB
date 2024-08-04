package me.tdd.book.week01.password;

public class PasswordStrengthMeter {

    public me.tdd.book.week01.password.PwSecurityLevel meter(String pw) {
        if (isEmpty(pw)) {
            return me.tdd.book.week01.password.PwSecurityLevel.INVALID;
        }

        switch(getMetCriteriaCnt(pw)) {
            case 2:
                return me.tdd.book.week01.password.PwSecurityLevel.MODERATE;
            case 3:
                return me.tdd.book.week01.password.PwSecurityLevel.STRONG;
            default:
                return PwSecurityLevel.WEEK;
        }
    }

    private int getMetCriteriaCnt(String pw) {
        return ( isContainsADigit(pw) ? 1 : 0 )
             + ( isMoreThanEightLength(pw) ? 1 : 0 )
             + ( isContainsCapitalLetter(pw) ? 1 : 0 );
    }

    private boolean isContainsCapitalLetter(String pw) {
        return pw.chars().anyMatch(Character::isUpperCase);
    }

    private boolean isMoreThanEightLength(String pw) {
        return pw.length() >= 8;
    }

    private boolean isContainsADigit(String pw) {
        return pw.matches(".*\\d.*");
    }

    private boolean isEmpty(String pw) {
        return pw == null || pw.isBlank();
    }
}
