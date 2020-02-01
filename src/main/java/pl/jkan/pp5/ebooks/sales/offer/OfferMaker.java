package pl.jkan.pp5.ebooks.sales.offer;


import pl.jkan.pp5.ebooks.sales.basket.BasketItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OfferMaker {
    public Offer calculateOffer(List<BasketItem> selectedItems) {

        List<OfferItem> offerItems = selectedItems.stream()
                .map(this::createOrderRow)
                .collect(Collectors.toList())
        ;

        return new Offer(offerItems);
    }

    public Offer calculateOffer(List<BasketItem> selectedItems, DiscountPolicy discountPolicy) {

        List<OfferItem> offerItems = selectedItems.stream()
                .map(this::createOrderRow)
                .collect(Collectors.toList())
        ;

        offerItems
            .forEach(item -> item.apply(discountPolicy.calculateDiscount(item)))
        ;

        return new Offer(offerItems);
    }

    private OfferItem createOrderRow(BasketItem basketItem) {
        OfferItem item = new OfferItem(
            basketItem.getId(),
            basketItem.getQuantity(),
            basketItem.getPrice().multiply(BigDecimal.valueOf(basketItem.getQuantity())).doubleValue()
        );

        return item;
    }
}
