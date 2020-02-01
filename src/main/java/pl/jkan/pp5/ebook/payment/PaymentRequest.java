package pl.jkan.pp5.ebook.payment;

import java.math.BigDecimal;

public class PaymentRequest {
    private String email;
    private final Integer money;
    private final String transactionId;

    public PaymentRequest(String email, Integer moneyAs100Cents, String transactionId) {
        this.email = email;
        this.money = moneyAs100Cents;
        this.transactionId = transactionId;
    }

    public String getEmail() {
        return email;
    }

    public Integer getMoney() {
        return money;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
