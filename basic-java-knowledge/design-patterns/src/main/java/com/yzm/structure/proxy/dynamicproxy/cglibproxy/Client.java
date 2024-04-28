package com.yzm.structure.proxy.dynamicproxy.cglibproxy;

import com.yzm.structure.proxy.dynamicproxy.jdkproxy.UserService;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setTarget(userService);
        UserServiceImpl proxy = (UserServiceImpl)userServiceProxy.getProxy();
        proxy.add();
    }

}
