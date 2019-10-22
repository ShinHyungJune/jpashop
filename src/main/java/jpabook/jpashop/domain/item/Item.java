package jpabook.jpashop.domain.item;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorColumn(name="dtype")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="items")
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private long price;

    private int stockQuantity;
}
