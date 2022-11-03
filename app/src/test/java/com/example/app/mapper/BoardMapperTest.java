package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

//    추가, 수정, 삭제
    @Test
    public void insertTest() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("류호근 제목");
        boardVO.setBoardWriter("류호근");
        boardVO.setBoardContent("류호근 내용");
        boardMapper.insert(boardVO);
        log.info("추가된 게시글 번호 : " + boardVO.getBoardNumber());
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(12L);

        // 실무에서 굉장히 많이 사용.
        // 오류를 내서 오류 설명을 볼 수 있다!! 훨씬 펺게!
        Assertions.assertNotNull(boardVO); // null 이 아니면

        boardVO.setBoardTitle("류호근 제목 수정2");
        boardVO.setBoardWriter("류호근 수정2");
        boardVO.setBoardContent("류호근 내용 수정2");
        boardMapper.update(boardVO);
    }

    @Test
    public void deleteTest(){
        // 컨트롤 알트 v 누르면 타입에 맞는 걸로 선언을 해준다.
        long boardNumber = 12L;
        BoardVO boardVO = boardMapper.select(boardNumber);
        Assertions.assertNotNull(boardVO);
        boardMapper.delete(boardNumber);
    }

}
