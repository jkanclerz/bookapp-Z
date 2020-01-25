package pl.jkan.pp5.ebook.productatalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue
    Long id;

    String title;
    String description;
    String cover;
    Boolean published;
    BigDecimal price;
}
