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
 * description:
 *
 * @author yzm
 * @date 2024/4/12  19:56
 */
public class XmlConfigBuilder {

    private Configuration configuration;

    public XmlConfigBuilder(){
        configuration = new Configuration();
    }

    /**
     * 使用dom4j+xpath
     *
     * @param inputStream
     * @return
     */
    public Configuration parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        // xpath表达式
        List<Element> elementList = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for(Element element:elementList){
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        // 1、解析配置文件
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getProperty("driver"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
        configuration.setDataSource(druidDataSource);

        // 2、解析映射配置文件
        // a、在mybatis-config.xml中获取映射配置文件的路径 b、根据路径解析映射配置文件 c、封装到MappedStatement对象
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for(Element element:mapperList) {
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return null;
    }
}
