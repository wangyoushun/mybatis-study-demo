package com.six.crud.testaction;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class BaseAction {
    public static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    public SqlSession sqlSession;

    public SqlSession batchSqlSession;

    @Before
    public void getSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession=build.openSession(false);
    }

    @Before
    public void getBatchSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        batchSqlSession=build.openSession(ExecutorType.BATCH, false);
    }
}
