package pl.jkan.pp5.ebook.sales;

import pl.jkan.pp5.ebook.sales.offer.CurrentOffer;

import java.math.BigDecimal;

public class SalesFacade {
    public void addProductToBasket(String productId) {
        //to be implemented
    }

    public CurrentOffer getCurrentOffer() {
        //getBasket -> calculate offer

        return new CurrentOffer(BigDecimal.valueOf(25.50));
    }
}
