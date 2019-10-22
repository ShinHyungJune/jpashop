package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor // final 변수만 allArgs생성자 만들어줌
public class MemberRepository {

    private final EntityManager em;
    /*
        @RequiredArgsConstructor 덕분에 밑에처럼 알아서 주입되는거임

        public MemberRepository(EntityManager em){
            this.em = em;
        }
    */

    public List<Member> getAll(){
        return em.createQuery("select m from Member m", Member.class) // Member m처럼 alias 써줘야돼
                .getResultList();
    }

    public void save(Member member){
        em.persist(member);
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
