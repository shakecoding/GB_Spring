package com.example.study1106.repository;

import com.example.study1106.domain.MemberCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCompanyRepository extends JpaRepository<MemberCompany,Integer> {
}
