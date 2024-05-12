package com.yzm.config;

import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * description:
 *
 * parse：解析映射配置文件-存储到mappedStatement对象-存储到Configuration的map中
 *
 * @author yzm
 * @date 2024/4/13
 */
public class XmlMapperBuilder {

    private Configuration configuration;

    public XmlMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {
        // 文档对象，就是 mapper/UserMapper.xml 对应的对象，还需要进一步解析
        Document document = new SAXReader().read(inputStream);
        // 根标签，即 mapper 标签
        Element rootElement = document.getRootElement();
        // 获取所有 select 标签
        List<Element> selectNodes = rootElement.selectNodes("//select");
        // 获取 namespace
        String namespace = rootElement.attributeValue("namespace");
        for (Element element : selectNodes) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            // 获取sql语句
            String sql = element.getTextTrim();
            // 封装mappedStatement对象
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setStatementId(namespace+"."+id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sql);
            mappedStatement.setSqlCommandType("select");
            // 将sql存到configuration的mappedStatementMap中，key为namespace.id
            configuration.getMappedStatementMap().put(namespace+"."+id, mappedStatement);
        }
    }
}
