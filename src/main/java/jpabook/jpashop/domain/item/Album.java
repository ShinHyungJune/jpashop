package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="albums")
public class Album extends Item {
    private String artist;
    private String etc;
}
