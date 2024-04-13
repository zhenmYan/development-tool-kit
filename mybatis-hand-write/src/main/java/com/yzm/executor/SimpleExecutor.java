package com.yzm.executor;

import com.yzm.config.BoundSql;
import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;
import com.yzm.utils.GenericTokenParser;
import com.yzm.utils.ParameterMapping;
import com.yzm.utils.ParameterMappingTokenHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:11
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param) throws SQLException {
        // 1、加载驱动，获取数据库连接
        Connection connection = configuration.getDataSource().getConnection();
        // 2、preparedStatement
        String sql = mappedStatement.getSql();
        /**
         * 需要将select * from user where id = #{id} and username = #{username};
         * 替换为select * from user where id = ？ and username = ？;
         * 才能被JDBC解析
         */
        BoundSql boundSql = getBoundSql(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql);

        return null;
    }

    @Override
    public void close() {

    }

    /**
     * 1、将 #{} 替换成？
     * 2、替换过程中将#{id}内的id保留下来，存放到ParameterMapping对象中
     *
     * @param sql
     * @return
     */
    public BoundSql getBoundSql(String sql){

        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();

        GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}",parameterMappingTokenHandler);

        String finalSql = genericTokenParser.parse(sql);

        ParameterMapping parameterMapping = parameterMappingTokenHandler.getParameterMapping();
        return null;
    }
}
