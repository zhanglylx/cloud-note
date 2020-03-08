package cn.zly.dao;

import cn.zly.entity.Share;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("shareDao")
public interface ShareDaoMapper extends ISqlMapper{
    void save(@Param("share") Share share);

    List<Share> findLikeTitle(@Param("title") String title);
}
