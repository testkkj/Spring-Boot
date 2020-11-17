package com.example.board.board.service;

import java.util.Iterator;
import java.util.List;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Service // 스프링 MVC 구조에서 서비스를 의미하는 어노테이션
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper; // 데이터 베이스에 접근하는 DAO빈을 선언

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList(); // 사용자 요청을 처리하기 위한 비지니스 로직을 구현하는 위치 조회에는 별다른 조작이 필요 없어서 조회 메서드만 호출
    }

    @Override
    public void insertBoard(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        //boardMapper.insertBoard(boardDto);
        if (ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String name;
            while (iterator.hasNext()) {
                name = iterator.next();
                log.debug("file tag name : " + name);
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
                for (MultipartFile multipartFile : list) {
                    log.debug("start file information");
                    log.debug("file name : " + multipartFile.getOriginalFilename());
                    log.debug("file size : " + multipartFile.getSize());
                    log.debug("file content type : " + multipartFile.getContentType());
                    log.debug("end file information. \n");
                }
            }
        }
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
