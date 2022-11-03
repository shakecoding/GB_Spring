package com.example.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class ProductControllerTest {

    // 컨트롤러 단위 테스트할 때는 무조건 이렇게!


    // 요 놈이 WAS 를 돌려준다.
    // WAS 가 이 객체를 관리해준다.
    // 얘로 사용자 요청을 받는다. 주입 요청 받으며 ㄴ알아서 함.
    // 서버 설정들이 여기 안에 다 들어가있다.
    @Autowired
    private WebApplicationContext webApplicationContext;

    //    브라우저에서 URL을 요청한 것과 같은 환경을 구성해준다.
    private MockMvc mockMvc;

    // 앞으로 @Test 어노테이션이 붙여있는 애가 실행되기 전에
    // 이것 부터 보는 것!
    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void showList() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/list")).andReturn().getModelAndView().toString());
    }

}
