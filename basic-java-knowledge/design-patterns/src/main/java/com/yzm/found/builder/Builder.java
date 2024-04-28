package com.yzm.found.builder;

/**
 * ##### 设计模式 design patterns 建造者模式
 *
 *      1、适用场景
 *          - 使用多个简单的对象一步一步构建成一个复杂的对象
 *
 *      2、特点
 *          - 分离了零件的构造（Builder来负责）和装配（Director负责）
 *
 *      3、组成部分
 *          - 建造者接口（如Mybatis的BaseBuilder）
 *          - 建造者接口实现类（如Mybatis的XMLConfigBuilder、XMLMapperBuilder等）
 *          - 产品类（如Mybatis的Configuration类）
 *          - 指挥者类（Director）
 *
 *      4、扩展类型
 *          - 对对象的属性进行链式赋值
 *          - lombok中的@Builder的底层就是基于该模式
 *
 * @author yzm
 * @date 2024/4/28
 */
public class Builder {

}
