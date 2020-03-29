package cn.zly.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoggerBean {
    @Before("within(cn.zly.contoller..*)")
    public void logController() {
        System.out.println("AOP功能注入");
    }

    @Before("within(cn.zly.service..*)")
    public void logService() {
        System.out.println("AOP注入Service");
    }

}
