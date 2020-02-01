package pl.jkan.pp5.ebooks.sales.basket;

import java.util.Optional;

public interface BasketStorage {
    Optional<Basket> loadForUser(String currentClientId);

    void save(String clientId, Basket basket);
}
