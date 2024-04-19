package com.yzm.pojo;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * description:
 *
 *      全局配置类，其中包含了mapper映射文件对象MappedStatement
 *
 * @author yzm
 * @date 2024/4/12
 */
public class Configuration {

    // 直接创建数据源对象
    private DataSource dataSource;

    // 合在一起，便于参数传递  key为statementId(namespace.id)
    private HashMap<String, MappedStatement> mappedStatementMap = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public HashMap<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(HashMap<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

}
