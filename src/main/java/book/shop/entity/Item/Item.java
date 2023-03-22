package book.shop.entity.Item;

import book.shop.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속관계 매핑 전략 지정
@DiscriminatorColumn(name = "dtype") // 하위 클래스에 @DiscriminatorValue 지정해줘야함
public abstract class Item {

    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    // 상품 이름
    @Column
    private String name;

    // 상품 가격
    @Column
    private int price;

    // 상품 수량
    @Column
    private int stockQuantity;

    // 다대다 매핑
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
