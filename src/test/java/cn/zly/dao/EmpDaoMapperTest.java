package cn.zly.dao;


import cn.zly.entity.Emp;
import dao.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class EmpDaoMapperTest implements BaseTest {
    private EmpDaoMapper empDaoMapper = ac.getBean("empDaoMapper", EmpDaoMapper.class);

    @Test
    public void save() {
        Emp emp = new Emp();
        emp.setName("主键自增");
        emp.setAge(88);
        empDaoMapper.save(emp);
        System.out.println(emp);
    }
}
