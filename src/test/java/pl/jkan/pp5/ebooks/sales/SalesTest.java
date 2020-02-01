package pl.jkan.pp5.ebooks.sales;

import org.junit.Before;
import org.junit.Test;
import pl.jkan.pp5.ebooks.modeling.Identifier;
import pl.jkan.pp5.ebooks.sales.basket.Basket;
import pl.jkan.pp5.ebooks.sales.basket.InMemoryBasketStorage;
import pl.jkan.pp5.ebooks.sales.products.InMemoryProductCatalog;
import pl.jkan.pp5.ebooks.sales.products.Product;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesTest {

    private final String PRODUCT_ID = Identifier.byString("test-product");
    private String currentUserId;
    private InMemoryProductCatalog productCatalog;

    @Before
    public void setup() {
        this.productCatalog = new InMemoryProductCatalog();
    }
    @Test
    public void itAllowAddProductToBasket() {
        thereIsClientIdentifiedWith("client_1");
        thereIsProductAvailableInCatalog(PRODUCT_ID);
        SalesFacade salesFacade = therIsSalesFacade();

        salesFacade.addToBasket(PRODUCT_ID);
        Basket basket = salesFacade.getBasket();

        assertThat(basket.productsCount()).isEqualTo(1);
    }

    private void thereIsProductAvailableInCatalog(String productId) {
        this.productCatalog.setAvailableProducts(Arrays.asList(new Product(productId, BigDecimal.valueOf(10.0))));
    }

    private void thereIsClientIdentifiedWith(String clientId) {
        this.currentUserId = clientId;
    }

    @Test
    public void itAllowAddProductToBasketBy2SeparatedClients() {
        thereIsProductAvailableInCatalog(PRODUCT_ID);

        thereIsClientIdentifiedWith("client_1");
        SalesFacade salesFacade = therIsSalesFacade();
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedBy1 = salesFacade.getBasket();


        thereIsClientIdentifiedWith("client_2");
        salesFacade.addToBasket(PRODUCT_ID);
        Basket basketOwnedBy2 = salesFacade.getBasket();

        assertThat(basketOwnedBy2).isNotEqualTo(basketOwnedBy1);
    }

    private SalesFacade therIsSalesFacade() {

        return new SalesFacade(
                () -> currentUserId,
                new InMemoryBasketStorage(),
                this.productCatalog);
    }
}
