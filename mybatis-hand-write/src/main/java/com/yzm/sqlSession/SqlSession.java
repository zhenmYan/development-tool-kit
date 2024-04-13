package com.yzm.sqlSession;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/13  15:08
 */
public interface SqlSession {

    <T> T select(String statementId, Object param);

    <E> List<E> selectList(String statementId, Object param);

    void close();

}
