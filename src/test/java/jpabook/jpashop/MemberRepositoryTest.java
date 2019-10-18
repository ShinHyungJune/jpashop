package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // jpa는 트랜잭션 내에서 쓰는게 필수야
    // @Rollback(false) 이렇게 써주면 테스트 실행 후 db가 롤백되지 않고 남아있음
    public void testMember() throws  Exception {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long id = memberRepository.save(member);
        Member findMember = memberRepository.find(id);

        // then
        Assertions.assertEquals(findMember.getId(), member.getId());
        Assertions.assertEquals(findMember, member);
    }
}