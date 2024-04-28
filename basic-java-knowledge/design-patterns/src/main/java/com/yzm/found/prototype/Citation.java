package com.yzm.found.prototype;

/**
 * ##### 设计模式 design patterns 原型模式
 *
 *      1、应用场景
 *          - 对象的重复创建
 *          - 例如对象的创建很复杂、或者需要大量的数据库操作
 *
 *      2、案例说明
 *          - 期末发奖状，奖状只有姓名不同
 *
 *      3、深克隆、浅克隆
 *          - 深克隆：
 *              - 创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址
 *              - 如序列化反序列化、递归深层次clone
 *          - 浅克隆：
 *              - 创建一个新对象、新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址
 *              - 如clone方法
 *
 * @author yzm
 * @date 2024/4/27
 */
public class Citation implements Cloneable {

    // 奖状上的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(this.name+"同学：在2024年第一学期中表现优秀，被评为三好学生，特发此状！");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation)super.clone();
    }

    // 测试
    public static void main(String[] args) throws CloneNotSupportedException {
        // 原型类
        Citation citation = new Citation();
        citation.setName("原型");
        // clone类
        Citation citation1 = citation.clone();
        Citation citation2 = citation.clone();
        Citation citation3 = citation.clone();

        citation1.setName("张三");
        citation2.setName("李四");
        citation3.setName("王五");

        citation1.show();
        citation2.show();
        citation3.show();

    }
}
