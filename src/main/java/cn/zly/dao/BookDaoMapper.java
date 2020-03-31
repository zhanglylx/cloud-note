package cn.zly.dao;

import cn.zly.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public interface BookDaoMapper extends ISqlMapper {
    List<Book> findByUserId(@Param("userId") String userId);

    void save(@Param("book") Book book);
}
