package com.yzm.executor;

import com.yzm.pojo.Configuration;
import com.yzm.pojo.MappedStatement;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:11
 */
public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param);

    void close();

}
