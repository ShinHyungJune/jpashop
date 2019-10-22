package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="deliveries")
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
