package com.yzm.filereader;

import java.io.*;

/**
 * ### java-io FileReader
 *
 *      字符集
 *          每次读取一个字符，底层也是字节流
 *
 *      read
 *          返回的是十进制
 *
 *      缓冲区
 *          关联文件，创建缓冲区（长度为8192的字节数组）
 *          第一次调用read时，会把缓冲区写满
 *
 *          后面每次读数据
 *              优先取缓冲区内容
 *              缓冲区没有则从文件中读，写到缓冲区
 *
 *
 * @author yzm
 * @date 2024/5/15
 */
public class FileReaderTest {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("basic-java-knowledge/java-io/src/main/resources/text/fileReader");

        // 1、循环读取
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        // 2、批量读取
        char[] chars = new char[2];
        int len;
        while ((len = reader.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }


        // 3、FileReader缓冲区
        // new FileReader 就会创建缓冲区字节数组
        Reader fr = new FileReader("basic-java-knowledge/java-io/src/main/resources/text/readersdbbhb");
        // 这里会将缓冲区写满
        fr.read();
        // 清空文件
        FileWriter fw = new FileWriter("basic-java-knowledge/java-io/src/main/resources/text/readersdbbhb");
        int c;
        // 这里还是会读到缓冲区的8192个数据，后面文件中的就读取不到了
        while ((c = fr.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
