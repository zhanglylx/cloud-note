package cn.zly.dao;

import cn.zly.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDaoMapper extends ISqlMapper {
    User findByName(String name);

    void save(@Param("user") User user);
}
