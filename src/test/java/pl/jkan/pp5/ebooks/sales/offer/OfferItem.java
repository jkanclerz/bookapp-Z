package pl.jkan.pp5.ebooks.sales.offer;


public class OfferItem {
    private String productId;
    private Integer quantity;
    private Double totalCost;
    private Discount discount;

    public OfferItem(String productId, Integer quantity, Double totalCost) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.discount = Discount.noDiscount();
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return (totalCost - discount.getValue()) <= 0 ? 0.00 : (totalCost - discount.getValue());
    }

    public void apply(Discount discount) {
        this.discount = discount;
    }
}
