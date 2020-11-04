package com.example.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * LoggerInterceptor
 */
@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {  //상속받은후 구현

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.debug("==================================================START==================================================");  //컨트롤러 시작지점 표시 및 URI 출력
        log.debug(" Request URI \t: " + request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.debug("==================================================END==================================================");  //컨트롤러 종료지검 표시
        super.postHandle(request, response, handler, modelAndView);
    }
}