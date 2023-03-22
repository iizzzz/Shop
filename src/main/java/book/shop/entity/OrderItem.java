package book.shop.entity;

import book.shop.entity.Item.Item;
import jakarta.persistence.*;
import lombok.Getter;

/* 주문과 상품을 이어주는 조인 테이블 */

@Entity @Getter
public class OrderItem {

    // PK
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    // 상품과 주문상품은 1:N 관계로 단방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    // 주문과 주문상품은 1:N 관계로 단방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // 주문 가격
    @Column
    private int orderPrice;

    // 주문 수량
    @Column
    private int count;

    // 연관관계 편의 메서드
    public void setOrder(Order order) {
        this.order = order;
    }
}
