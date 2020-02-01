package pl.jkan.pp5.ebooks.sales.basket;

import java.math.BigDecimal;

public class BasketItem {
    private String id;
    private Integer quantity;
    private BigDecimal price;

    public BasketItem(String id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public BasketItem(String id, Integer quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = BigDecimal.valueOf(price);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
