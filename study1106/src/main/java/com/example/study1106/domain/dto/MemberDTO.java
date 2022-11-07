package com.example.study1106.domain.dto;


import com.example.study1106.domain.MemberCompany;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class MemberDTO {
    private Integer memberNumber;

    private List<MemberCompany> memberCompanies;
    private String memberId;
    private String memberName;
    private String memberGender;
    private Integer memberAge;

}
