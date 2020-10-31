package com.example.board.service;

import java.util.List;

import com.example.board.dto.BoardDto;

/**
 * BoardService
 */
public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto boardDto) throws Exception;
}