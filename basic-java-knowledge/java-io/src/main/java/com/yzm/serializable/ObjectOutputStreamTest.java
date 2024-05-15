package com.yzm.serializable;

import java.io.*;

/**
 * ##### java-io 序列化
 *
 *      - 对java对象进行传输
 *          - 如果使用字节流或字符流，中间传输的数值是可以被修改的
 *          - 而序列化流则传输的是对象
 *
 *
 *      - 注意
 *          - 序列化id：序列化传输的对象需要实现Serializable接口
 *          - 固定版本号：修改对象User时，会修改序列化id，所以需要定义一个序列化id
 *
 *
 * @author yzm
 * @date 2024/5/15
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 写入
        User user = new User("zhangsan", 18);
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("basic-java-knowledge/java-io/src/main/resources/text/serializable"));
        oos.writeObject(user);
        oos.close();

        // 读取
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("basic-java-knowledge/java-io/src/main/resources/text/serializable"));
        Object o = ois.readObject();
        System.out.println(o);
    }
}
