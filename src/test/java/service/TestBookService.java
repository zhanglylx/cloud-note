package service;

import cn.zly.service.BookService;
import dao.BaseTest;
import org.junit.Test;

public class TestBookService implements BaseTest {
    BookService bookService = ac.getBean("bookService",BookService.class);
    @Test
    public void TestLoadUserBooks(){
        System.out.println(bookService.loadUserBooks("dd068ec76d89ee2f569b4822c81ecdd3"));

    }
}
