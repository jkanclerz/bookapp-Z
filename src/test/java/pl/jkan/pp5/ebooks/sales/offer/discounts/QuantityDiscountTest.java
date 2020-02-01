package pl.jkan.pp5.ebooks.sales.offer.discounts;

import org.junit.Assert;
import org.junit.Test;
import pl.jkan.pp5.ebooks.sales.offer.Discount;
import pl.jkan.pp5.ebooks.sales.offer.OfferItem;

import java.util.UUID;

public class QuantityDiscountTest {
    @Test
    public void itApplyDiscountBasedOnQuantity() {
        QuantityDiscount discount = new QuantityDiscount(5, 0.20);
        OfferItem item = new OfferItem(UUID.randomUUID().toString(), 5, 50.00);

        Discount d = discount.calculateDiscount(item);
        item.apply(d);

        Assert.assertTrue(40.00 == item.getTotalCost());
    }
}
