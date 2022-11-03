package com.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTest {
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
    // 잘못된 경로를 요청할 수도 있기에 이셉션을 잡아준다.
    public void showTest() throws  Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void writeTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/write")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void writeTest2() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/write").param("boardTitle", "Post 선두주자").param("boardWriter", "류호근이다").param("boardContent", "성공했다")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void readTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read").param("boardNumber", "1")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void updateTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/update").param("boardNumber", "1")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void updateTest2() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/update").param("boardTitle", "Post 선두주자2").param("boardContent", "성공했다2").param("boardNumber", "33")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void deleteTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/delete").param("boardNumber", "10")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void deleteTest2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/board/delete")
        .param("boardNumber", "7")).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }




}
