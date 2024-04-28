package com.yzm.structure.proxy.dynamicproxy.jdkproxy;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Client {
    public static void main(String[] args) {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理类
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setTarget(userService);
        //使用代理类实现日志功能！
        UserService proxy = (UserService)userServiceProxy.getProxy();

        proxy.add();
    }
}
