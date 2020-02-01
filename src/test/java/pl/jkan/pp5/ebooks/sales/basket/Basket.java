package pl.jkan.pp5.ebooks.sales.basket;


import pl.jkan.pp5.ebooks.sales.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Basket {
    public static Basket empty() {
        return new Basket();
    }

    private final HashMap<Product, Integer> productQuantities;

    public Basket() {
        this.productQuantities = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!isInBasket(product)) {
            putToBasket(product);
        } else {
            increaseQuantity(product);
        }
    }

    public List<BasketItem> getReservedProducts() {
        ArrayList<BasketItem> items = new ArrayList<>(productQuantities.size());

        productQuantities.forEach((product, quantity) -> items.add(new BasketItem(String.valueOf(product.getId()), quantity, product.getPrice())));

        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return productQuantities.isEmpty();
    }

    public int productsCount() {
        return productQuantities.size();
    }

    private void putToBasket(Product product) {
        productQuantities.put(product, 1);
    }

    private void increaseQuantity(Product product) {
        productQuantities.put(product, productQuantities.get(product) + 1);
    }

    private boolean isInBasket(Product product) {
        return productQuantities.containsKey(product);
    }

    public void clear() {
        this.productQuantities.clear();
    }
}
