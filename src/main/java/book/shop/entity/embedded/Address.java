package book.shop.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

/* 임베디드 값 타입 클래스 */

@Embeddable
@Getter
public class Address {
    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String zipCode;

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    protected Address() {}
}
