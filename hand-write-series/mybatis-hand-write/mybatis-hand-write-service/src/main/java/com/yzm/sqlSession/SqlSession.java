package com.yzm.sqlSession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 *      - 添加增删改查方法
 *             - selectOne()
 *             - selectList()
 *             ...
 *      - 这里的方法不直接调用Jdbc，而是委派给Executor去执行
 *
 * @author yzm
 * @date 2024/4/13
 */
public interface SqlSession {

    <T> T selectOne(String statementId, Object param) throws IllegalAccessException, ClassNotFoundException, IntrospectionException, InstantiationException, SQLException, InvocationTargetException, NoSuchFieldException;

    <E> List<E> selectList(String statementId, Object param) throws IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException;

    void close();

    /**
     * 生成代理对象
     *
     * @param mapperClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<?> mapperClass);

}
