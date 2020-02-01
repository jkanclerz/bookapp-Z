package pl.jkan.pp5.ebooks.sales.offer;

public class OfferData {
    private Double total;
    private Integer itemsCount;
    private String currency = "PLN";

    public OfferData(Double total, Integer itemsCount) {
        this.total = total;
        this.itemsCount = itemsCount;
    }

    public static OfferData zeroValue() {
        return new OfferData(0d, 0);
    }

    public Double getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public String getCurrency() {
        return currency;
    }
}
