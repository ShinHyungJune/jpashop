package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 조회할 때 성능최적화해줌
@RequiredArgsConstructor // final 변수만 allArgs 생성자 만들어줌
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> get(){
        return memberRepository.getAll();
    }

    @Transactional // readonly하면 저장 안되므로 별도로 표기
    public Long store(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);

        return member.getId();
    }

    public Member show(Long id){
        return memberRepository.find(id);
    }

    private void validateDuplicateMember(Member member){
        List<Member> members = memberRepository.findByName(member.getName());

        if(!members.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
