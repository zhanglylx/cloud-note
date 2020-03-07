package dao;

import cn.zly.dao.UserDaoMapper;
import cn.zly.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao implements BaseTest{

    UserDaoMapper userDao = ac.getBean("userDao", UserDaoMapper.class);

    @Test
    public void testFindByName() {
        System.out.println(userDao.findByName("1"));
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setCn_user_id("324234");
        user.setCn_user_name("测试");
        user.setCn_user_nick("名称");
        user.setCn_user_password("密码");
        user.setCn_user_tonken("token");
        userDao.save(user);
    }

}
