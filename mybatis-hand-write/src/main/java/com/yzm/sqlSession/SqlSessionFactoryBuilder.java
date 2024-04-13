package com.yzm.sqlSession;

import com.yzm.config.XmlConfigBuilder;
import com.yzm.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/12  19:53
 */
public class SqlSessionFactoryBuilder {

    /**
     * 解析配置文件、创建SqlSessionFactory对象
     *
     * @param inputStream
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException {

        // 1、解析配置文件，封装到Configuration类
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parse(inputStream);

        // 2、创建
        return null;
    }
}
