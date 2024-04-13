package com.yzm.sqlSession;

import com.yzm.config.XmlConfigBuilder;

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
    public SqlSessionFactory build(InputStream inputStream) {

        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        return null;
    }
}
