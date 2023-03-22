package book.shop.entity.Item;

import jakarta.persistence.*;
import lombok.Getter;

@Entity @Getter
@DiscriminatorValue("A")
public class Album extends Item {

    @Column
    private String artist;

    @Column
    private String etc;
}
