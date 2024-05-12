package com.yzm.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
/**
 * ##### 自定义MyBatis Configuration
 *
 *      1、全局配置类，存放配置文件中解析的内容
 *
 *      2、其中包含了mapper映射文件对象MappedStatement，
 *      把MappedStatement放在Configuration里的目的是只需要读取一次文件即可，即配置文件，配置文件中包含了映射文件的路径
 *
 *      3、dataSource时通过数据库连接信息创建的数据源对象
 *
 * @author yzm
 * @date 2024/4/12
 */
public class Configuration {

    // 直接创建数据源对象
    private DataSource dataSource;

    // 合在一起，便于参数传递  key为statementId(namespace.id)
    private HashMap<String, MappedStatement> mappedStatementMap = new HashMap<>(256);

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
