package com.example.study1106.repository;


import com.example.study1106.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    public Member findByMemberNumber(Integer memberNumber);
    public Member findByMemberName(String memberName);
}
