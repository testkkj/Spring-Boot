package com.example.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspects {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
}
