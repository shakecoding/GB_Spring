package com.example.study1106.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="member")
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNumber;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberCompany> memberCompanies;
    private String memberId;
    private String memberName;
    private String memberGender;
    private Integer memberAge;



}
