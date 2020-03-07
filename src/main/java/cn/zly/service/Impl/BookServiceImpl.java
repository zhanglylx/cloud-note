package cn.zly.service.Impl;

import cn.zly.dao.BookDaoMapper;
import cn.zly.entity.Book;
import cn.zly.service.BookService;
import cn.zly.util.NoteResult;
import cn.zly.util.NoteUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource(name = "bookDao")
    private BookDaoMapper bookDaoMapper;

    @Override
    public NoteResult<List<Book>> loadUserBooks(String userId) {
        NoteResult<List<Book>> noteResult = new NoteResult<>();
        if (StringUtils.isBlank(userId)) {
            noteResult.setStatus(1);
            noteResult.setMsg("用户ID为空");
            return noteResult;
        }
        noteResult.setStatus(0);
        noteResult.setData(bookDaoMapper.findByUserId(userId));
        noteResult.setMsg("查询笔记本成功");
        return noteResult;
    }

    @Override
    public NoteResult<Book> addBooks(String userId, String title) {
        NoteResult<Book> noteResult = new NoteResult<>();
        if (StringUtils.isBlank(userId)) {
            noteResult.setStatus(2);
            noteResult.setMsg("userId不能为空");
            return noteResult;
        }
        if (StringUtils.isBlank(title)) {
            noteResult.setStatus(2);
            noteResult.setMsg("title不能为空");
            return noteResult;
        }
        Book book = new Book();
        book.setCn_notebook_id(NoteUtil.createId());
        book.setCn_user_id(userId);
        book.setCn_notebook_desc("");
        book.setCn_notebook_type_id("1");
        book.setCn_notebook_name(title);
        book.setCn_notebook_status(1);
        long time = System.currentTimeMillis();
        book.setCn_notebook_createtime(new Timestamp(time));
        try {
            bookDaoMapper.save(book);
            noteResult.setStatus(0);
            noteResult.setMsg("保存book成功");
            noteResult.setData(book);
            return noteResult;
        } catch (Exception e) {
            e.printStackTrace();
            noteResult.setStatus(1);
            noteResult.setMsg("创建失败，服务端错误");
            return noteResult;
        }


    }
}
