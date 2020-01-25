package pl.jkan.pp5.ebook.productatalog;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductCatalogFacadeTest {

    @Test
    public void itAllowAddBookToCatalog() {
        ProductCatalogFacade api = new ProductCatalogFacade();
        Book book = thereIsBookIWouldLikeToHave();
        api.addBook(book);

        List<Book> books = api.allBooks();
        assertThat(books).hasSize(1);
    }

    private Book thereIsBookIWouldLikeToHave() {
        return Book.builder()
                .cover("https://picsum.photos/200/300")
                .title("Pragmatic Programmer")
                .description("Journey from beginner to Master")
                .price(BigDecimal.valueOf(120.00))
                .published(true)
                .build();

    }
}
