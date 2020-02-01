package pl.jkan.pp5.ebooks.sales.offer;


import pl.jkan.pp5.ebooks.sales.offer.discounts.QuantityDiscount;

public class DiscountFactory {
    private static DiscountPolicy quantityDiscount() {
        return new QuantityDiscount(5, 0.20);
    }

    private static DiscountPolicy poppyAndJazzyDiscount() {
        return new QuantityDiscount(5, 0.20);
    }
}
