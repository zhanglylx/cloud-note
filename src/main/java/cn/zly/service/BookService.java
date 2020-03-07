package cn.zly.service;

import cn.zly.entity.Book;
import cn.zly.util.NoteResult;

import java.util.List;

public interface BookService {
    NoteResult<List<Book>> loadUserBooks(String userId);
    NoteResult<Book> addBooks(String userId,String title);
}
