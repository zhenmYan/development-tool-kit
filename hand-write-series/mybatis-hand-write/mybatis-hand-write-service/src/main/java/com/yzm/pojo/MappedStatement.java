package com.yzm.pojo;

/**
 * ##### 自定义MyBatis MappedStatement
 *
 *      1、mapper文件的映射对象，每条sql对应一个MappedStatement对象
 *
 * @author yzm
 * @date 2024/4/12
 */
public class MappedStatement {

    // 唯一标识 statementId  ：  namespace.id
    private String statementId;
    // 返回值类型
    private String resultType;
    // 参数类型
    private String parameterType;
    // sql语句
    private String sql;
    // 用于判断是增删改查的那种操作
    private String sqlCommandType;

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(String sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

}
