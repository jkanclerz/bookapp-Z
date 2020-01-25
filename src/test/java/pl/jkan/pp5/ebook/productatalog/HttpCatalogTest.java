package pl.jkan.pp5.ebook.productatalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HttpCatalogTest {
    @Autowired
    TestRestTemplate http;
    @Autowired
    ProductCatalogFacade productCatalogFacade;
    @LocalServerPort
    int port;

    @Test
    public void itAllowListProductsViaHttpEndpoint() {
        thereIsPublishedBook("Lord of the ring");
        thereIsPublishedBook("Hobbit");

        ResponseEntity<Book[]> response = http.getForEntity(
                String.format("http://localhost:%s/api/products", port),
                Book[].class
        );

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .hasSize(2);
        assertThat(mapToTitles(response.getBody())).contains("Hobbit");
        assertThat(mapToTitles(response.getBody())).contains("Lord of the ring");
    }

    private List<String> mapToTitles(Book[] array) {
        return Stream.of(array)
                .map(b -> b.title)
                .collect(Collectors.toList());
    }

    private void thereIsPublishedBook(String title) {
        productCatalogFacade.addBook(Book.builder()
            .title(title)
            .description(title)
            .cover("http://cover.dev")
            .price(BigDecimal.valueOf(20.20))
            .published(true)
            .build()
        );
    }

}
