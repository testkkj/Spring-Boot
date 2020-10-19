package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@RestController 어노테이션 해당 클래스가 REST 컨트롤러 기능을 수행하도록 설정
public class HelloController {

    @RequestMapping("/")  //@RequestMapping 어노테이션 해당 메서드를 실행할 주소를 설정
    public String hello() {  //설정된 주소로 접속했을때 실행될 메서드
        return "Hello World!";
    }
}
