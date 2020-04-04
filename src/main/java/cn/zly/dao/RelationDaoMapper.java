package cn.zly.dao;

import cn.zly.entity.Book;
import cn.zly.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("relationDaoMapper")
public interface RelationDaoMapper extends ISqlMapper {
    //    关联多个对象
    User findUserAndBooks(@Param("userId") String userId);

    User findUserAndBooks1(@Param("userId") String userId);

    //    关联单个对象
    List<Book> findBookAndUser();
    List<Book> findBookAndUser1();
}
