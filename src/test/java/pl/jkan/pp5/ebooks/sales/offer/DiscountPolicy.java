package pl.jkan.pp5.ebooks.sales.offer;

public interface DiscountPolicy {
    public Discount calculateDiscount(OfferItem item);
}
