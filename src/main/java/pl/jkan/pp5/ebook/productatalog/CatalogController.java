package pl.jkan.pp5.ebook.productatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {
    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @GetMapping("/products")
    List<Book> listAllBooks() {
        return productCatalogFacade.allBooks();
    }
}
