package dao;

import cn.zly.dao.BookDaoMapper;
import org.junit.Test;

public class BookTestDao implements BaseTest {
    BookDaoMapper bookDaoMapper = ac.getBean("bookDao", BookDaoMapper.class);
    @Test
    public void findByNameTest(){
        System.out.println(bookDaoMapper.findByUserId("1"));
    }
}
