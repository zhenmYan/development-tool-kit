package com.yzm.pojo;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * description:
 *
 *      全局配置类
 *
 * @author yzm
 * @date 2024/4/12  18:57
 */
public class Configuration {

    private DataSource dataSource;

    private HashMap<String, MappedStatement> mappedStatementMap;

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
