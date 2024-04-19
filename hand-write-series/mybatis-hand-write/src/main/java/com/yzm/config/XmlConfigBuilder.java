package com.yzm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yzm.io.Resources;
import com.yzm.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * description:采用dom4j+xpath解析，封装Configuration类
 *
 * @author yzm
 * @date 2024/4/12
 */
public class XmlConfigBuilder {

    private Configuration configuration;

    public XmlConfigBuilder(){
        configuration = new Configuration();
    }

    /**
     * 采用dom4j+xpath解析，封装Configuration类
     *
     * @param inputStream
     * @return
     */
    public Configuration parse(InputStream inputStream) throws DocumentException {
        // 文档对象，就是mybatis-config.xml对应的对象，还需要进一步解析
        Document document = new SAXReader().read(inputStream);
        // 根标签，即configuration标签
        Element rootElement = document.getRootElement();
        // xpath表达式  找所有的property 例如 <property name="driver" value="com.mysql.jdbc.Driver" />是一个property
        List<Element> elementList = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for(Element element:elementList){
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        // 1、创建数据源对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getProperty("driver"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
        configuration.setDataSource(druidDataSource);

        /**
         * 2、解析映射配置文件
         *      - 在mybatis-config.xml中获取映射配置文件的路径
         *      - 根据路径解析映射配置文件
         *      - 封装到MappedStatement对象
         */
        // 例如 <mapper resource="com/yzm/dao/UserMapper.xml"></mapper>
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for(Element element:mapperList) {
            // 这里mapperPath为com/yzm/dao/UserMapper.xml
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);
            // 对单个Mapper文件再进行解析
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return configuration;
    }
}
