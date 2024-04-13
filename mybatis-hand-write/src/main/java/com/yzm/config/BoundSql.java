package com.yzm.config;

import com.yzm.utils.ParameterMapping;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  17:30
 */
public class BoundSql {

    private String finalSql;

    private List<ParameterMapping> list;

    public String getFinalSql() {
        return finalSql;
    }

    public void setFinalSql(String finalSql) {
        this.finalSql = finalSql;
    }

    public List<ParameterMapping> getList() {
        return list;
    }

    public void setList(List<ParameterMapping> list) {
        this.list = list;
    }
}
