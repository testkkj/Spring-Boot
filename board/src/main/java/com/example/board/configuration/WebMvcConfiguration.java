package com.example.board.configuration;

import com.example.board.interceptor.LoggerInterceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfiguration
 */
public class WebMvcConfiguration implements WebMvcConfigurer{  //어떤 클래스를 상속받는지는 교재에 나와 있지 않음.

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new LoggerInterceptor());  //특정 패턴은 지정되지 않은 상태, add/exclude pathpatterns() 로 적용할 패턴 작성 가능
        
    }

}