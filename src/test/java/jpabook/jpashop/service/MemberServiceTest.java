package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 사용자는_회원가입을_할_수_있다() throws Exception {
        String name = "kim";

        // given
        Member member = new Member();
        member.setName(name);

        // when
        Long id = memberService.store(member);

        // then
        assertEquals(member, memberService.show(id));
    }

    @Test
    public void 사용자는_중복된_이름으로_회원가입을_할_수_없다() throws Exception {
        String sameName = "kim";

        // given
        Member member01 = new Member();
        member01.setName(sameName);

        Member member02 = new Member();
        member02.setName(sameName);

        // when
        memberService.store(member01);

        // then
        assertThrows(IllegalStateException.class, () -> memberService.store(member02));
    }
}