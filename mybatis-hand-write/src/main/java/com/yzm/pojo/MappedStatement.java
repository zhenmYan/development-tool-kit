package com.yzm.pojo;

/**
 * description:
 *      mapper文件的映射对象，每条sql对应一个MappedStatement对象
 *
 * @author yzm
 * @date 2024/4/12  18:50
 */
public class MappedStatement {

    // 唯一标识 statementId  ：  namespace.id
    private String  statementId;
    // 返回值类型
    private String resultType;
    // 参数类型
    private String parameterType;
    // sql语句
    private String sql;

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

}
