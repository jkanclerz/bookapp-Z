package pl.jkan.pp5.ebook.productatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfiguration {

    @Bean
    ProductCatalogFacade facade(BookRepository repository) {
        return new ProductCatalogFacade(repository);
    }
}
