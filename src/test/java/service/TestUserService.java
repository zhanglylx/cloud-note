package service;

import cn.zly.entity.User;
import cn.zly.service.UserService;
import cn.zly.util.NoteResult;
import dao.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService implements BaseTest {
    UserService service = ac.getBean("userService", UserService.class);;



    @Test
    public void test1() {
        NoteResult<User> noteResult = this.service.checkLogin("1", "1");
        System.out.println(service.getClass().getName());
        System.out.println(noteResult);
    }

    @Test
    public void test2() {
        NoteResult noteResult = this.service.addUser("1", "22","ces");
        System.out.println(noteResult);
    }


}
