package com.yzm.sqlSession;

import com.yzm.config.XmlConfigBuilder;
import com.yzm.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * ##### 自定义MyBatis SqlSessionFactoryBuilder
 *
 *      用于构建 SqlSessionFactory，可以在 SqlSessionFactory 中获取 SqlSession
 *
 * @author yzm
 * @date 2024/4/12
 */
public class SqlSessionFactoryBuilder {

    /**
     *
     * 1、采用dom4j+xpath解析，封装Configuration类
     * 2、创建SqlSessionFactory对象并作为返回值
     *
     * @param inputStream
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException {

        // 1、采用dom4j+xpath解析，封装Configuration类
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parse(inputStream);

        // 2、创建SqlSessionFactory对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }

}
