package pl.jkan.pp5.ebooks.sales.offer;

import org.junit.Assert;
import org.junit.Test;
import pl.jkan.pp5.ebooks.modeling.Identifier;


public class OfferItemTest {

    @Test
    public void itAllowApplyDiscountForItem() {
        OfferItem item = new OfferItem(Identifier.byString("p1"), 4, 10.00);
        item.apply(new Discount("static reduce", 5.00));

        Assert.assertTrue("Should match reduced price", item.getTotalCost() == 5.00);
    }

    @Test
    public void itReducePriceToMax0() {
        OfferItem item = new OfferItem(Identifier.byString("p1"), 4, 10.00);
        item.apply(new Discount("static reduce", 100.00));

        Assert.assertTrue("Should match reduced price", item.getTotalCost() == 0);
    }
}
