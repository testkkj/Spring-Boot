package com.example.board.mapper;

import java.util.List;

import com.example.board.dto.BoardDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper  //ibatis 매퍼임을 선언하는 어노테이션
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;  //인터페이스이기 때문에 메서드 이름과 반환형식만 지정 메서드 이름과 SQL의 이름은 같아야 함

    void insertBoard(BoardDto boardDto) throws Exception;
}
