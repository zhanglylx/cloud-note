package cn.zly.dao;

import cn.zly.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("relationDaoMapper")
public interface RelationDaoMapper extends ISqlMapper {
    User findUserAndBooks(@Param("userId") String userId);
    User findUserAndBooks1(@Param("userId") String userId);
}
