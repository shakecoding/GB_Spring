package com.example.study1106.MemberRepository;

import com.example.study1106.domain.Member;
import com.example.study1106.domain.MemberCompany;
import com.example.study1106.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;



    @Test
    public void saveTest(){
        Member member = new Member();
        member.setMemberId("jwp0124");
        member.setMemberName("박종우");
        member.setMemberAge(26);
        member.setMemberGender("남자");
        memberRepository.save(member);
    }

    @Test
    public void findByMemberNumberTest(){
        Member member =memberRepository.findByMemberNumber(1);
        System.out.println(member.toString());
    }

    @Test
    public void findByMemberNameTest(){
        Member membere = memberRepository.findByMemberName("박종우");
        System.out.println(membere);
    }

    @Test
    public void deleteTest(){
        memberRepository.deleteById(1);
    }

    @Test
    public void updateTest(){
        Member member = memberRepository.findByMemberNumber(2);
        member.setMemberGender("여자");
        memberRepository.save(member);
    }

    @Test
    @Transactional
    public void selectTest(){
        Member member = memberRepository.findByMemberNumber(2);
        System.out.println(member.getMemberCompanies());
    }

}
