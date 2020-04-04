package cn.zly.dao;

import cn.zly.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("noteDao")
public interface NoteDaoMapper extends ISqlMapper {
    List<Map> findByBookId(@Param("bookId") String bookId);

    Note findByNoteId(@Param("noteId") String noteId);
    int updateNote(@Param("note") Note note);
    int updateNoteByMap(@Param("note") Map<String,Object> map);

    void save(@Param("note") Note note);


}
