package com.example.study1106.domain;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="member_company")
@Data
public class MemberCompany {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyNumber;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_number")
    private Member member;

    @Column(name="member_company")
    private String memberCompany;


}
