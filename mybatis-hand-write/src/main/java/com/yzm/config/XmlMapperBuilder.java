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
 * @date 2024/4/13  14:33
 */
public class XmlMapperBuilder {

    private Configuration configuration;

    public XmlMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> selectNodes = rootElement.selectNodes("//select");
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
            configuration.getMappedStatementMap().put(namespace+"."+id, mappedStatement);
        }
    }
}
