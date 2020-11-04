package com.example.board.controller;

import java.util.List;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

//1import org.slf4j.Logger;
//1import org.slf4j.LoggerFactory;
/**
 * 로그 사용시 특정 로깅 구현체 패키지를 사용하지 않음
 * 스프링부트 기본 logback, 사용로거는 slf4j 의존성사용
 * logback 이외의 라이브러리로 변경에 용이
 * 추가로 찾아봐야함
 */

@Slf4j  //lombok사용시 이 어노테이션으로 import1와 로거2를 생성하지 않아도 된다.
@Controller  //스프링 MVC의 컨트롤러를 의미 어노테이션을 작성하면 컨트롤러로 작동
public class BoardController {
    //2private Logger log = LoggerFactory.getLogger(this.getClass());  // 파라미터는 로거의 이름 "NAME"일 경우 NAME 로거의 이름 대체로 클래스 이름으로 생성 이경우 패키지이름+클래스이름으로 생성됨

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/openBoardList.do")  //주소를 설정하는 어노테이션 브라우저에서 괄호안 주소를 호출하면 스프링디스패쳐가 입력주소와 매칭되는 requestmapping 주소를 찾아서 메서드를 실행
    public ModelAndView openBoardList() throws Exception{
        log.debug("openBoardList");
        ModelAndView mv = new ModelAndView("/board/boardList");  //괄호는 html 파일 주소 즉 template 아래에 board/boardList.html을 의미 thymeleaf 등의 템플릿을 사용하면 스프링부트가 자동으로 생략된 html을 입력해줌

        List<BoardDto> list = boardService.selectBoardList();  //게시글 목록을 조회한다 는 비지니스 로직을 수행하는 boardService 아래의 selectBoardList메서드를 호출 목록 저장을 위해 List형태로 저장
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping("/board/openBoardWrite.do")  //게시글 작성화면을 호출하는 주소
    public String openBoardWrite() throws Exception {
        return "/board/boardWrite";
    }

    @RequestMapping("/board/insertBoard.do")  //게시글 등록하는 주소 html 폼의 액션과 같은 값
    public String insertBoard(BoardDto boardDto) throws Exception {
        boardService.insertBoard(boardDto);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardDetail");

        BoardDto boardDto = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board", boardDto);

        return mv;
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto boardDto) throws Exception {

        boardService.updateBoard(boardDto);

        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception {

        boardService.deleteBoard(boardIdx);

        return "redirect:/board/openBoardList.do";
    }
}
