package book.shop.entity.Item;

import jakarta.persistence.*;
import lombok.Getter;

@Entity @Getter
@DiscriminatorValue("M")
public class Movie extends Item {

    @Column
    private String director;
    private String actor;
}
