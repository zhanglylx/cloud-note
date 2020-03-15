package cn.zly.dao;

import cn.zly.entity.Share;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("shareDao")
public interface ShareDaoMapper extends ISqlMapper {
    void save(@Param("share") Share share);

    List<Share> findLikeTitle(@Param("map") Map<String, Object> title);
}
