package book.shop.entity;

import book.shop.entity.embedded.Address;
import book.shop.entity.status.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter
public class Delivery {

    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    // 배송과 주문은 1:1 관계이다
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    @Setter
    private Order order;

    // 임베디드 값 타입
    @Embedded
    private Address address;

    // 배송 상태 [READY, COMP]
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
