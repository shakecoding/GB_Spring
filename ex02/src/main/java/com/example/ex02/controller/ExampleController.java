package com.example.ex02.controller;

import com.example.ex02.domain.vo.MemberVO;
import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.domain.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// 스프링에 등록해주는 것
@Controller
@Slf4j
@RequestMapping("/ex/*") // 서블릿으로 갈 수 있게끔 경로를 등록해주는 곳.
// 이걸로 시작하는 애들 다 들어와 (상위 경로로 판단.)
public class ExampleController {

    @RequestMapping(value = "ex01", method = {RequestMethod.GET, RequestMethod.POST}) // value 생략하면 get, post 정할 수 없을 것 같당.
    // 위에 경로 뒤에 들어갈 경로를 적어주는 것.
    public void ex01(){
        log.info("ex01.....................");
        // return 을 String 타입으로 해 주면 그 String의 html 을 찾아서 실행해준다.
        // 없으면 경로에 해당하는 것을 찾는다.
        // 기본적으로 templates 안에서 찾음.
        // 경로를 추가하면 앞에 경로까지 적어준다. 예) test.index
        // 뒤에 .html 을 적어주면 2중으로 들어가기에 안된다.
    }

    @GetMapping("ex02")
    public void ex02(HttpServletRequest request){
        log.info("name: " + request.getParameter("name"));
    }

    @GetMapping("ex03")
    public void ex03(String name){
        log.info("name: " + name);
    }

    @GetMapping("ex04")
    public void ex04(MemberVO memberVO){
        log.info("member : " + memberVO);
    }

    // name 을 id 로
    // 무조건 필드명과 매핑.
    // 특이점이 있을 수 있으니 알고만 있자!
    // 필드명을 다르게 해서 하는 방법은 있긴 하다!
    // 기존에 있는 페이지를 재사용할 때 사용한다.
    @GetMapping("ex05")
    public void ex05(@RequestParam("id") String name, int age){ // 자동으로 형변환까지 가능!
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex06")
    public void ex06(MemberVO memberVO){
        log.info("ex06....................");
    }

    // ModelAttribute 는 하나만 쓴다. 더 길어지면 DTO
    @GetMapping("ex07")
    public void ex07(@ModelAttribute("gender") String gender, MemberVO memberVO){
        log.info("ex07....................");
        log.info("memberVO : " + memberVO);
        log.info("gender: " + gender);
    }

    // [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form 태그로 전송한다.
    @GetMapping("ex08")
    public void ex08(){

    }

    @GetMapping("ex08_1")
    public void ex08_1(ProductVO productVO){
        log.info("ex08..................");
        log.info("productVO : " + productVO);
    }

    //    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력

    @GetMapping("ex09")
    public void ex09(TaskVO taskVO){
        log.info("ex08..................");
        log.info("productVO : " + taskVO);
        taskVO.setNum(taskVO.getEng() + taskVO.getKor() + taskVO.getMath());
    }

    //    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력
    @GetMapping("login")
    public void login(){

    }

    @GetMapping("check")
    public String check(String id){
        if(id.equals("admin")){
            return "ex/admin";
        }else if(id.equals("user")){
            return "ex/user";
        }
        return null;
    }


    //    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
    @GetMapping("work/checkWork")
    public void checkWork(){

    }




}
