package cn.zly.contoller;

import cn.zly.entity.Book;
import cn.zly.service.BookService;
import cn.zly.util.NoteResult;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class LoadBooksController {

    @Resource(name = "bookService")
    private BookService bookService;

    @RequestMapping(value = "/loadBooks.do",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public NoteResult<List<Book>> loadBooks(@RequestParam("userId") String userId) {
        return bookService.loadUserBooks(userId);
    }

}
