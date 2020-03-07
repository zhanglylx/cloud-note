package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface BaseTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
}
