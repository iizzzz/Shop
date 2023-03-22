package book.shop.entity;

import book.shop.entity.status.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "orders")
public class Order {

    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // 멤버와 주문은 1:N으로 단방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 주문은 배송과 1:1 관계이다
    // 1:1 관계에서 Access가 더 많은 쪽을 키의 주인으로 지정했음
    // 주문을 볼때 배송정보가 무조건 필요하니 FetchType은 즉시 전략을 사용한다
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    // 주문 시간
    @Column
    private LocalDateTime orderDate;

    // 주문의 상태 필드 [ORDER, CANCEL]
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
