package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * @SpringBootApplication 어노테이션 스프링 부트의 핵심으로 봐도 무방함 아래 3가지 어노테이션으로 구성
 * @EnableAutoConfiguration 어노테이션 스프링의 다양한 설정이 자동으로 완성됨
 * @ComponentScan 어노테이션 기존 스프링 빈(Bean) 클래스를 위해 XML에 등록 필요 / 컴포넌트 검색기능으로 자동으로
 *                컴포넌트를 검색 등록 해줌
 * @Configuration 어노테이션 직접 포함되진 않았지만 @SpringBootConfiguration이 포함되어 있고 이
 *                어노테이션(config)은 스프링부트에 해당 파일이 설정 파일임을 명시 사용해 XML이 아닌 자바기반 설정 가능
 */
public class DemoApplication {

	public static void main(String[] args) { // SpringApplication.run() 메소드로 애플리케이션 실행 가능 / xml 파일 없이 순수 자바로 개발 가능(일부
												// 라이브러리 제외)
		SpringApplication.run(DemoApplication.class, args);
	}

}
