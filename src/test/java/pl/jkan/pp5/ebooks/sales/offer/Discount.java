package pl.jkan.pp5.ebooks.sales.offer;

public class Discount {
    private String cause;
    private Double value;

    public Discount(String cause, Double value) {
        this.cause = cause;
        this.value = value;
    }

    public static Discount noDiscount(){
        return new Discount("No discount", 0.0);
    }

    public String getCause() {
        return cause;
    }

    public Double getValue() {
        return value;
    }
}
