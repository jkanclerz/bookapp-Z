package pl.jkan.pp5.ebook.productatalog;

import java.util.List;

public class ProductCatalogFacade {
    private BookRepository repository;

    public ProductCatalogFacade(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public List<Book> allBooks() {
        return repository.findAll();
    }
}
