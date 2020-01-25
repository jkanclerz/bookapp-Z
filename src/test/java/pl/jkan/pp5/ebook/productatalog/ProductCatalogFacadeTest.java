package pl.jkan.pp5.ebook.productatalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCatalogFacadeTest {

    @Autowired
    BookRepository repository;

    @Test
    public void itAllowAddBookToCatalog() {
        ProductCatalogFacade api = new ProductCatalogFacade(repository);
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
