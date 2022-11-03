package com.example.app.controller;

import com.example.app.domain.vo.BoardVO;
import com.example.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

//    @Qualifier("notice") 이거 없어도 프라이머리인 커뮤니티 구현체가 들어올 것이다.
    // 해당 객체 위에 붙이기
    private final BoardService boardService;

//    게시글 목록
    @GetMapping("/list")
    public void list(Model model){ // 데이터 전달자는 Model
        model.addAttribute("boards", boardService.show());
    }

//    게시글 등록
    @GetMapping("/write")
    public void write(){

    }

    @PostMapping("/write")
    public void write(BoardVO boardVO){
        boardService.add(boardVO);
    }

//    게시글 수정, 게시글 상세보기
    @GetMapping(value = {"read", "update"})
    public void read(Long boardNumber, Model model){
        model.addAttribute("board", boardService.find(boardNumber));
    }

    @PostMapping("/update")
    public RedirectView update(BoardVO boardVO, RedirectAttributes redirectAttributes){
        boardService.update(boardVO);
        // read로 넘어가기 위해선 boardNumber 를 들고가야한다. 몇번 게시글인지 알아야하기에

        // 첫번째 방법!
        // 이렇게 쓰면 응답하는 곳 뒤에 쿼리스트링을 알아서 만들어준다.
        // 다른 컨트롤러로 이동할 때에는 쿼리스트링으로 전달해야 한다.
        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());

        // 두번째 방법! 세션으로 넘기는 것
        // 화면에서만 사용할 때에는 Flash영역을 사용하여 전달해야 한다.
//        redirectAttributes.addAttribute("boardNumber", boardVO.getBoardNumber());

        // redirect 는 컨트롤러에서 컨트롤러로 이동할 대 무조건 써줘야한다.
        return new RedirectView("/board/read");
    }

//    게시글 삭제
    @PostMapping("/delete")
    public RedirectView delete(Long boardNumber){
        boardService.delete(boardNumber);
        return new RedirectView("/board/list");
    }

    /* Model 객체는 forward 방식,
    * RedirectAttributes 는 리다이렉트 방식.
    * 리다이렉트는 쿼리스티링과 세션으로 값을 넘길 수 있다. */

}
