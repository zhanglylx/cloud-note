package cn.zly.contoller;

import cn.zly.entity.Book;
import cn.zly.service.BookService;
import cn.zly.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class AddBookController {
    @Resource(name = "bookService")
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    public NoteResult<Book> addBook(@RequestParam("userId") String userId, @RequestParam("title") String title) {
        return bookService.addBooks(userId, title);
    }
}
