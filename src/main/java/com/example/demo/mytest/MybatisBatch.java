package com.example.demo.mytest;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MybatisBatch {

    @Autowired
    public SqlSessionFactory sqlSessionFactory;

    public void batch(){
        SqlSession session=sqlSessionFactory.openSession(ExecutorType.BATCH);
//        session.getMapper()
    }
}
