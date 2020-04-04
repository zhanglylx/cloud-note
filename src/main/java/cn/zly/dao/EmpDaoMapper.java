package cn.zly.dao;

import cn.zly.entity.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("empDaoMapper")
public interface EmpDaoMapper extends ISqlMapper {
    void save(@Param("emp") Emp emp);
}
