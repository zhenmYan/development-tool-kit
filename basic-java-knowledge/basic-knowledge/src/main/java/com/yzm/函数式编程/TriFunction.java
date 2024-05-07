package com.yzm.函数式编程;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/7
 */
@FunctionalInterface
public interface TriFunction <T, U, K, R>
{
    R apply(T t, U u, K k);
}