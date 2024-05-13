package com.yzm.sqlSession;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/12
 */
public interface SqlSessionFactory {

    /**
     * 1、创建SqlSession
     * 2、创建sql执行器Executor
     *
     * @return
     */
    SqlSession openSession();

}
