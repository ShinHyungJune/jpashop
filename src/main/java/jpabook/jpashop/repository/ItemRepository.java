package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public List<Item> getAll(){
        return em.createQuery("select i from Item i", Item.class);
    }

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item); // 추가
        }else{
            em.merge(item); // id가 있다면 이미 있는 데이터이므로 update 개념으로 작업해야됨
        }
    }

    public Item find(Long id){
        return em.find(Item.class, id);
    }
}
