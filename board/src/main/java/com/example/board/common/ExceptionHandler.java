package com.example.board.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest httpServletRequest, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("/error/error_default");
        modelAndView.addObject("exception", exception);

        logger.error("exception", exception);

        return modelAndView;
    }

}