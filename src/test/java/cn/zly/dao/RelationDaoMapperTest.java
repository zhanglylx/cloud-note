package cn.zly.dao;

import dao.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class RelationDaoMapperTest implements BaseTest {
    private RelationDaoMapper relationDaoMapper = ac.getBean("relationDaoMapper", RelationDaoMapper.class);
//关联多个对象
    @Test
//    多条语句
    public void findUserAndBooks() {
        System.out.println(relationDaoMapper.findUserAndBooks("dd068ec76d89ee2f569b4822c81ecdd3"));
    }

    @Test
//    单条语句
    public void findUserAndBooks1() {
        System.out.println(relationDaoMapper.findUserAndBooks1("dd068ec76d89ee2f569b4822c81ecdd3"));
    }
//    关联单个对象
    @Test
//    多条语句
    public void findBookAndUser(){
        System.out.println(relationDaoMapper.findBookAndUser());
    }

    @Test
//    单调语句
    public void findBookAndUser1(){
        System.out.println(relationDaoMapper.findBookAndUser1());
    }
}
