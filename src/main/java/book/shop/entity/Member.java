package book.shop.entity;

import book.shop.entity.embedded.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter
public class Member {

    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column @Setter
    private String name;

    @Embedded
    private Address address;
}
