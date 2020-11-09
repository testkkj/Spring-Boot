package com.example.board.service;

import java.util.List;

import com.example.board.dto.BoardDto;
import com.example.board.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 스프링 MVC 구조에서 서비스를 의미하는 어노테이션
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper; // 데이터 베이스에 접근하는 DAO빈을 선언

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList(); // 사용자 요청을 처리하기 위한 비지니스 로직을 구현하는 위치 조회에는 별다른 조작이 필요 없어서 조회 메서드만 호출
    }

    @Override
    public void insertBoard(BoardDto boardDto) throws Exception {
        boardMapper.insertBoard(boardDto);
    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        boardMapper.updateHitCount(boardIdx);

        BoardDto boardDto = boardMapper.selectBoardDetail(boardIdx);

        return boardDto;
    }

    @Override
    public void updateBoard(BoardDto boardDto) throws Exception {
        boardMapper.updateBoard(boardDto);
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        boardMapper.deleteBoard(boardIdx);
    }
}
