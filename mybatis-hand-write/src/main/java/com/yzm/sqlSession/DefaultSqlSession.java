package com.yzm.sqlSession;

import com.yzm.executor.Executor;
import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:08
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T select(String statementId, Object param) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException {
        List<Object> list = this.selectList(statementId, param);
        if (list.size() == 1){
            return (T)list.get(0);
        } else if (list.size() > 1){
            throw new RuntimeException("");
        } else {
            return null;
        }
    }

    @Override
    public <E> List<E> selectList(String statementId, Object param) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        // 委派给执行器Executor
        List<E> list = executor.query(configuration, mappedStatement, param);
        return null;
    }

    @Override
    public void close() {
        executor.close();
    }
}
