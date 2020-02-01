package pl.jkan.pp5.ebook.sales.offer;

import java.math.BigDecimal;

public class CurrentOffer {
    BigDecimal money;

    public CurrentOffer(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
