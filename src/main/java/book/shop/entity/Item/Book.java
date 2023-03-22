package book.shop.entity.Item;

import jakarta.persistence.*;
import lombok.Getter;

@Entity @Getter
@DiscriminatorValue("B")
public class Book extends Item {

    @Column
    private String author;

    @Column
    private String isbn;
}
