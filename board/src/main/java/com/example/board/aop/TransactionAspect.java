package com.example.board.aop;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class TransactionAspect {
    private static final String AOP_TRANSACTION_METHOD_NAME = "*";
    private static final String AOP_TRANSACTION_EXPRESSION = "execution(* board..service.*Impl.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor transactionAdvice() {
        MatchAlwaysTransactionAttributeSource alwaysTransactionAttributeSource =
        new MatchAlwaysTransactionAttributeSource();
        RuleBasedTransactionAttribute ruleBasedTransactionAttribute =
        new RuleBasedTransactionAttribute();
        ruleBasedTransactionAttribute.setName(AOP_TRANSACTION_METHOD_NAME);        
        ruleBasedTransactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        alwaysTransactionAttributeSource.setTransactionAttribute(ruleBasedTransactionAttribute);

        return new TransactionInterceptor(transactionManager, alwaysTransactionAttributeSource);
    }

    @Bean
    public Advisor transactionAdviceAdvisor() {
        AspectJExpressionPointcut aspectJExpressionPointcut =
        new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(AOP_TRANSACTION_EXPRESSION);
        return new DefaultPointcutAdvisor(aspectJExpressionPointcut, transactionAdvice());
    }
}
