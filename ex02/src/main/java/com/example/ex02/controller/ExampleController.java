package com.example.ex02.controller;

import com.example.ex02.domain.vo.MemberVO;
import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.domain.vo.TaskVO;
import com.example.ex02.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

// 스프링에 등록해주는 것
@Controller
@Slf4j
@RequestMapping("/ex/*") // 서블릿으로 갈 수 있게끔 경로를 등록해주는 곳.
// 이걸로 시작하는 애들 다 들어와 (상위 경로로 판단.)
@RequiredArgsConstructor
public class ExampleController {

    private final TimeMapper timeMapper;

    @RequestMapping(value = "ex01", method = {RequestMethod.GET, RequestMethod.POST}) // value 생략하면 get, post 정할 수 없을 것 같당.
    // 위에 경로 뒤에 들어갈 경로를 적어주는 것.
    public void ex01(Model model){
        log.info("ex01.....................");
        // return 을 String 타입으로 해 주면 그 String의 html 을 찾아서 실행해준다.
        // 없으면 경로에 해당하는 것을 찾는다.
        // 기본적으로 templates 안에서 찾음.
        // 경로를 추가하면 앞에 경로까지 적어준다. 예) test/index
        // 뒤에 .html 을 적어주면 2중으로 들어가기에 안된다.

//        model.addAllAttributes("now", timeMapper.getTime());
    }

    // getParameter 로 쿼리스트링을 받아야 했지만,
    @GetMapping("ex02")
    public void ex02(HttpServletRequest request){
        log.info("name: " + request.getParameter("name"));
    }

    // 스프링에서는 바로 매개변수로 받아도 가능.
    @GetMapping("ex03")
    public void ex03(String name){
        log.info("name: " + name);
    }

    // 모델 안에 선언해 놓은 필드명으로 매핑 가능.
    // 쿼리스트링도 필드명과 똑같이 적어주면 된다.
    @GetMapping("ex04")
    public void ex04(MemberVO memberVO){
        log.info("member : " + memberVO);
    }

    // name 을 id 로
    // 무조건 필드명과 매핑.
    // 특이점이 있을 수 있으니 알고만 있자!
    // 필드명을 다르게 해서 하는 방법은 있긴 하다!
    // 기존에 있는 페이지를 재사용할 때 사용한다.
    // Get 방식은 대부분 Page 이동
    // Post 방식은 DB CRUD

    /*필드의 이름과 쿼리스트링의 이름을 다르게 사용하기 위해서는 모델 객체를 매개변수로 할 수 없다.
    * 어노테이션을 적어주어 id에 있는 key값을 name에 넣어주어라가 된다.
    * 저 name(id 값이 들어간)을 가지고 메소드 실행.*/
    @GetMapping("ex05")
    public void ex05(@RequestParam("id") String name, int age){ // 자동으로 형변환까지 가능!
        log.info("name : " + name);
        log.info("age : " + age);
    }

    // 화면에서 출력하는 예시.
    // 여기에서 요청하는 경로는 ex/ex06
    // 우리가 html 만든 경로도 ex/ex06
    // 기본적으로 templates 부터 시작한다. 그렇기에 이것이 알맞은 경로에 만든 것!
    // 타임리프 추가! 저기 안에 있는 라이브러리는 가져와서 th 를 활용하여 사용.
    // get 생략하고 필드명만 적더라도 가능. JSP 에서와 똑같이!
    // memberVO 가 반복될 때에 th:object="{memberVO}"
    // 밑에는 $ 아닌 참조의 표시인 *
    @GetMapping("/ex06")
    public void ex06(MemberVO memberVO){
        log.info("ex06....................");
    }

    // ModelAttribute 는 하나만 쓴다. 더 길어지면 DTO
    // 매개변수 순서의 차이도 없다.
    // 우리가 만들어준 자료형(클래스, 모델객체)는 쉽게 불러오지만
    // 일반 자료형(string, int 등등)은 쉽게 불러오지 못한다. 우리가 직접 해줘야한다.
    // @ModelAttribute("gender") String gender, gender 라는 key 값으로 전달 가능!
    // gender 는 ex07.html 에서 뿌려주는 것!
    // 하나만 쓸 때만 이 문법 사용!
    // 많아지면 Model model 을 매개변수에 적고 model.addAttribute 를 메소드 안에 적어주어
    // map 형식으로 보내주어야 한다.
    // 하지만 대부분 2개 이상이 되면 DTO를 쓴다.
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

    @GetMapping("/exam")
    public String exam(){
        return "exam/exam";
    }

    @PostMapping("/exam")
    public String exam(TaskVO taskVO){
        return "exam/result";
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
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");


    @GetMapping("work/checkWork")
    public void checkWork(){

    }

    @GetMapping("work/getToWork")
    public void getToWork(){
        simpleDateFormat.format(date);
    }




}
