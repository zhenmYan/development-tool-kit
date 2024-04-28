package com.yzm.structure.proxy.dynamicproxy.cglibproxy;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class UserServiceImpl {

    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("更新了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}
