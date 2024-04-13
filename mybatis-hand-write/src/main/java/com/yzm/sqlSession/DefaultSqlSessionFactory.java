package com.yzm.sqlSession;

import com.yzm.executor.Executor;
import com.yzm.executor.SimpleExecutor;
import com.yzm.pojo.Configuration;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:03
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSqlSession() {
        Executor executor = new SimpleExecutor();
        SqlSession sqlSession = new DefaultSqlSession(configuration, executor);
        return sqlSession;
    }
}
