package com.yzm.sqlSession;

import com.yzm.executor.Executor;
import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
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

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        Object proxy = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),
                new Class[]{mapperClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 通过调用sqlSession委派给executor
                        /**
                         * 参数的准备：
                         *      statementId、param
                         *
                         * 问题1：
                         *      无法获取statementId
                         * 解决办法：
                         *      1、使接口全路径和namespace一致
                         *      2、接口中的方法名要和id的值一致
                         *      从而可以通过method去获取statementId、param的值
                         *
                         * 问题2：
                         *      要调用哪个方法
                         * 解决办法
                         *      MappedStatement的sqlCommandType记录是什么操作
                         *
                         * 问题3：
                         *      要调用select还是selectList
                         * 解决办法
                         *      利用method的getGenericReturnType
                         *
                         */
                        // selectAll
                        String methodName = method.getName();
                        // com.yzm.dao.UserDao
                        String className = method.getDeclaringClass().getName();
                        String statementId = className + "." + methodName;
                        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
                        String sqlCommandType = mappedStatement.getSqlCommandType();
                        switch (sqlCommandType){
                            case "select":
                                Type genericReturnType = method.getGenericReturnType();
                                if (genericReturnType instanceof ParameterizedType){
                                    if (args != null) {
                                        return selectList(statementId, args[0]);
                                    } else {
                                        return selectList(statementId, null);
                                    }
                                } else {
                                    return select(statementId, args[0]);
                                }
                            case "update":
                            case "insert":
                            case "delete":
                        }

                        return null;
                    }
                });
        return (T)proxy;
    }
}
