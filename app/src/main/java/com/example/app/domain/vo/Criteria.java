package com.example.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria {
    private int page; // 현재 페이지
    private int amount; // 한 페이지당 게시물 갯수

    public void createCriteria(){
        createCriteria(1, 10);
    }

    public void createCriteria(int page, int amount){
        this.page = page;
        this.amount = amount;
    }

    // 앞이 get 이기에 get 빼고 사용해도 알아서 게터를 호출하듯이 사용 가능.
    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();

    }

}
