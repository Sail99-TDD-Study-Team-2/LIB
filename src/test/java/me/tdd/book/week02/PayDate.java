package me.tdd.book.week02;

import java.time.LocalDate;

public class PayDate {

    private LocalDate payFirstDate;
    private LocalDate payDate;
    private int payAmount;

    public PayDate() {}

    public PayDate(LocalDate payFirstDate, LocalDate payDate, int payAmount) {
        this.payFirstDate = payFirstDate;
        this.payDate = payDate;
        this.payAmount = payAmount;
    }

    public LocalDate getPayFirstDate() {
        return payFirstDate;
    }

    public void setPayFirstDate(LocalDate payFirstDate) {
        this.payFirstDate = payFirstDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayDate payDate = new PayDate();

        public PayDate build() {
            return payDate;
        }

        public Builder payDate(LocalDate payDate) {
            this.payDate.setPayDate(payDate);
            return this;
        }

        public Builder payAmount(int payAmount) {
            this.payDate.setPayAmount(payAmount);
            return this;
        }

        public Builder payFirstDate(LocalDate payFirstDate) {
            this.payDate.setPayFirstDate(payFirstDate);
            return this;
        }
    }
}
