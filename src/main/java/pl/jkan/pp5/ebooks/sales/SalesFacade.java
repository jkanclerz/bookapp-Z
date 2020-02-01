package pl.jkan.pp5.ebooks.sales;


import pl.jkan.pp5.ebooks.sales.basket.Basket;
import pl.jkan.pp5.ebooks.sales.basket.BasketStorage;
import pl.jkan.pp5.ebooks.sales.exceptions.NoSuchProductException;
import pl.jkan.pp5.ebooks.sales.offer.OfferData;
import pl.jkan.pp5.ebooks.sales.products.Product;
import pl.jkan.pp5.ebooks.sales.products.ProductCatalog;

public class SalesFacade {
    private SystemUserContext systemUserContext;
    private BasketStorage basketStorage;
    private ProductCatalog productCatalog;

    public SalesFacade(SystemUserContext systemUserContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        this.systemUserContext = systemUserContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }

    public void addToBasket(String productId) {
        String currentClientId = systemUserContext.getCurrentUserId();

        Basket basket = basketStorage.loadForUser(currentClientId).orElse(
                Basket.empty()
        );
        Product product = productCatalog.load(productId)
                .orElseThrow(() -> new NoSuchProductException());

        basket.addProduct(product);

        basketStorage.save(currentClientId, basket);
    }

    public Basket getBasket() {
        String currentClientId = systemUserContext.getCurrentUserId();

        Basket basket = basketStorage.loadForUser(currentClientId)
                .orElse(Basket.empty());

        return basket;
    }

    public OfferData currentOffer() {
        return OfferData.zeroValue();
    }

}
