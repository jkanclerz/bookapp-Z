package pl.jkan.pp5.ebook.productatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class CatalogConfiguration {

    @Bean
    ProductCatalogFacade facade(BookRepository repository) {
        ProductCatalogFacade productCatalogFacade = new ProductCatalogFacade(repository);

        productCatalogFacade.addBook(
                thereIsPublishedBook("Hobbit"));
        productCatalogFacade.addBook(
                thereIsPublishedBook("Lord of the ring"));

        return productCatalogFacade;
    }

    private Book thereIsPublishedBook(String title) {
        return Book.builder()
                .title(title)
                .description(title)
                .cover("https://picsum.photos/200/300")
                .price(BigDecimal.valueOf(20.20))
                .published(true)
                .build();
    }
}
