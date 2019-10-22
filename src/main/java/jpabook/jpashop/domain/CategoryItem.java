package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;

import javax.persistence.*;

@Entity
public class CategoryItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
}
