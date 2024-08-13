package me.tdd.book.Week03;

import java.time.LocalDateTime;

public class AutoDebitRegister {

    private CardNumberValidator validator;
    private AutoDebitInfoRepository repo;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repo) {
        this.validator = validator;
        this.repo = repo;
    }

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.getCardNumber());

        if(validity != validity.VALID){
            return RegisterResult.error(validity);
        }

        AutoDebitInfo info = repo.findOne(req.getUserId());

        if(info == null){
            info.changeCardNumber(req.getCardNumber());
        } else {
            AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
            repo.save(newInfo);
        }

        return RegisterResult.success();
    }
}
