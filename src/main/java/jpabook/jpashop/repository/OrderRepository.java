package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public List<Order> getAll(){
        em.createQuery("select o from Order o", Order.class);
    }

    public void save(Order order){
        if(order.getId() == null){
            em.persist(order); // 추가
        }else{
            em.merge(order); // id가 있다면 이미 있는 데이터이므로 update 개념으로 작업해야됨
        }
    }

    public Order find(Long id){
        em.find(id, Order.class);
    }
}
