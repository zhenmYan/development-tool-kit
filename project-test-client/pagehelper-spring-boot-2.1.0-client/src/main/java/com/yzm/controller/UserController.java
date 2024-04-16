package com.yzm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzm.dao.User;
import com.yzm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ##### pageHelper的使用
 *
 *      一、使用方式
 *          1、传统方式
 *              - 设置分页信息
 *              - 查询
 *              - 返回结果
 *          2、使用lambda语句
 *              - PageInfo<User> pageInfo = PageHelper.startPage(1,5)
 *                 .doSelectPageInfo(()->userMapper.selectAll());
 *
 *      二、失效场景
 *          1、分页设置与需要分页的查询之间存在其他查询
 *              - PageHelper.startPage(pageNum,pageSize);需要与查询语句紧紧挨着
 *          2、在需要分页的查询后才设置分页
 *              - 需要先设置分页，再查询
 *              - 和情况1类似
 *          3、需要引入pagehelper-spring-boot-starter包
 *              - 单独引入pagehelper源码包会无法生效
 *              - 而过单独引入pagehelper，可以通过注入配置类com.yzm.config.PageHelperConfig使分页生效
 *
 *       三、核心思想
 *          1、通过对Excutor的query方法进行拦截
 *          2、总共执行两条sql
 *              - 查询总数：executeAutoCount方法
 *              - 查询具体值：pageQuery方法
 *          3、两条sql都是通过对boundSql进行修改实现的
 *
 * @author yzm
 * @date 2024/4/16  18:01
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 接口测试
     *
     * @param id
     * @return
     */
    @RequestMapping("/user")
    public User queryUser(int id){
        User user = userService.selectById(id);
        return user;
    }

    // 请求：http://localhost:8080/user/list?pageNum=1&pageSize=5
    @RequestMapping("/user/list")
    public PageInfo<User> queryUserList(int pageNum, int pageSize){
        return userService.selectUserList(pageNum, pageSize);
    }

}
