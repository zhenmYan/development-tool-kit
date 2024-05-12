package com.yzm.executor;

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
 * @date 2024/4/13
 */
public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param)
            throws SQLException, ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException;

    void close();

}
