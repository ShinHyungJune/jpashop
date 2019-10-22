package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<CategoryItem> categoryItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category){
        this.categories.add(category);

        category.setCategory(this);
    }

    public void setCategory(Category category){
        this.category = category;

        category.setCategory(this);
    }
}
