package com.example.study1106.MemberRepository;

import com.example.study1106.domain.MemberCompany;
import com.example.study1106.repository.MemberCompanyRepository;
import com.example.study1106.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class Test {
    @Autowired
    MemberCompanyRepository memberCompanyRepository;
    @Autowired
    MemberRepository memberRepository;

    @org.junit.jupiter.api.Test
    public void saveTest(){
        MemberCompany memberCompany = new MemberCompany();
        memberCompany.setMember(memberRepository.findByMemberNumber(2));
        memberCompany.setMemberCompany("카카오");
        memberCompanyRepository.save(memberCompany);
    }
    @org.junit.jupiter.api.Test
    public void selectTest(){
        Optional<MemberCompany> memberCompany = memberCompanyRepository.findById(1);
        System.out.println(memberCompany);
    }











        @org.junit.jupiter.api.Test
        public void test(){
            MemberCompany memberCompany = new MemberCompany();
            memberCompany.setMember(memberRepository.findByMemberNumber(2));
            memberCompany.setMemberCompany("sadfas");
            memberCompanyRepository.save(memberCompany);
        }
}
