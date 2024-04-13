package com.yzm.executor;

import com.yzm.config.BoundSql;
import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;
import com.yzm.utils.GenericTokenParser;
import com.yzm.utils.ParameterMapping;
import com.yzm.utils.ParameterMappingTokenHandler;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:11
 */
public class SimpleExecutor implements Executor {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param)
            throws RuntimeException, SQLException, ClassNotFoundException,
            IllegalAccessException, InvocationTargetException, NoSuchFieldException,
            InstantiationException, IntrospectionException {
        List<E> result = new ArrayList<>();
        // 1、加载驱动，获取数据库连接
        this.connection = configuration.getDataSource().getConnection();
        // 2、preparedStatement
        String sql = mappedStatement.getSql();
        /**
         * 需要将select * from user where id = #{id} and username = #{username};
         * 替换为select * from user where id = ？ and username = ？;
         * 才能被JDBC解析
         */
        BoundSql boundSql = getBoundSql(sql);
        this.preparedStatement = connection.prepareStatement(boundSql.getFinalSql());

        // 3、设置参数
        String parameterType = mappedStatement.getParameterType();
        Class<?> parameterTypeClass = Class.forName(parameterType);
        List<ParameterMapping> parameterMappings = boundSql.getList();
        for (int i = 0; i < parameterMappings.size(); i++){
            ParameterMapping parameterMapping = parameterMappings.get(i);
            String paramName = parameterMapping.getContent();
            // 反射获取属性，就是查找有什么字段，如id
            Field declaredField = parameterTypeClass.getDeclaredField(paramName);
            declaredField.setAccessible(true);
            // 在param对象中获取id的值
            Object o = declaredField.get(param);
            // jdbc对变量赋值
            preparedStatement.setObject(i+1, o);
        }
        // 发起查询
        this.resultSet = preparedStatement.executeQuery();
        // 处理返回结果集
        while (resultSet.next()){
            // 元数据信息，包含字段名和字段值
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 获取resultType，用于结果集封装
            String resultType = mappedStatement.getResultType();
            Class<?> resultTypeClass = Class.forName(resultType);
            Object o = resultTypeClass.newInstance();
            for(int i = 1; i<= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = resultSet.getObject(columnName);
                // 属性描述器，通过api获取某个属性的读写方法
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                // 参数1：实例对象，也就是User对象  参数2：字段值
                writeMethod.invoke(o, columnValue);
            }
            result.add((E) o);
        }
        return result;
    }

    @Override
    public void close() {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 1、将 #{} 替换成？
     * 2、替换过程中将#{id}内的id保留下来，存放到ParameterMapping对象中
     *
     * @param sql
     * @return
     */
    public BoundSql getBoundSql(String sql){
        BoundSql boundSql = new BoundSql();
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}",parameterMappingTokenHandler);
        String finalSql = genericTokenParser.parse(sql);
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        boundSql.setFinalSql(finalSql);
        boundSql.setList(parameterMappings);
        return boundSql;
    }
}
