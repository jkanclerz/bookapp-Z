package pl.jkan.pp5.ebooks.sales.offer;

import java.util.Collections;
import java.util.List;

public class Offer {

    private List<OfferItem> items;


    public Offer(List<OfferItem> items) {
        this.items = items;
    }

    public List<OfferItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Double getTotal() {
        Double total = items.stream()
            .map(OfferItem::getTotalCost)
            .reduce((item, acc) -> acc + item)
            .orElse(0.0)
        ;

        return total;
    }
}
