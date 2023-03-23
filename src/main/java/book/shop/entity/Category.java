package book.shop.entity;

import book.shop.entity.Item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Category {

    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    // 카테고리 이름
    @Column
    private String name;

    // 다대다는 중간 테이블이 필요하므로 JoinTable로 만들어준다.
    // joinColumns와 inverseJoinColumns는 조인테이블에 FK 컬럼을 만들어준다.
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    // 카테고리의 계층 구조를 위한 Self 양방향 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @Setter
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 편의 메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
