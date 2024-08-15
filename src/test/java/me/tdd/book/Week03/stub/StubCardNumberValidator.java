package me.tdd.book.Week03.stub;

import me.tdd.book.Week03.CardNumberValidator;
import me.tdd.book.Week03.CardValidity;

public class StubCardNumberValidator extends CardNumberValidator {

    private String invalidNo;
    private String theftNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if(invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }

        if(theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }

        return CardValidity.VALID;
    }
}
