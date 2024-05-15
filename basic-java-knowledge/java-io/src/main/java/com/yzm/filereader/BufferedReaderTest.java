package com.yzm.filereader;

import java.io.*;

/**
 * ### java-io BufferedReader
 *
 *      两个重要方法
 *          readLine：读一行
 *          newLine：换行
 *
 *      8192字符数组，占16k
 *
 *
 *
 * @author yzm
 * @date 2024/5/15
 */
public class BufferedReaderTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("basic-java-knowledge/java-io/src/main/resources/text/bufferedReader"));
        // 读一行
        String s = bufferedReader.readLine();
        System.out.println(s);

        // 循环读取
        String line;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
