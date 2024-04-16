package com.yzm.controller.user;

import com.yzm.dao.User;
import com.yzm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ##### pageHelper的使用
 *
 *
 *
 * @author yzm
 * @date 2024/4/16  18:01
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/hello1")
    public String hello1(int id){
        return "hello world"+id;
    }

    @RequestMapping("/user")
    public User queryUser(int id){
        User user = userService.selectById(id);
        return user;
    }
}
