package pl.jkan.pp5.ebooks.sales.products;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductCatalog implements ProductCatalog {

    private List<Product> availableProducts = new ArrayList<>();

    @Override
    public Optional<Product> load(String productId) {
        return availableProducts.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    public void setAvailableProducts(List<Product> asList) {
        this.availableProducts = asList;
    }
}
