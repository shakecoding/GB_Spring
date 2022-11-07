package com.example.app.service;

import com.example.app.domain.vo.BoardVO;
import com.example.app.domain.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링에 알려주는 어노테이션.

// 일반인 들도 알 수 있는 메소드 이름으로 바꾸어준다.
public interface BoardService {
    //    게시글 목록
    public List<BoardVO> show(Criteria criteria);
    //    게시글 조회
    public BoardVO find(Long boardNumber);
    //    게시글 추가
    public boolean add(BoardVO boardVO);
    //    게시글 수정
    public boolean update(BoardVO boardVO);
    //    게시글 삭제
    public boolean delete(Long boardNumber);
    //    게시글 전체 갯수
    public int getTotal();
}
