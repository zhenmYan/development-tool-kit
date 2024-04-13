package com.yzm.sqlSession;

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

        return null;
    }
}
