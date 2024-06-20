package com.yzm.数字与字母;/**
 * @author yan
 * @date 2024/6/10
 * @Description
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ##### 正则匹配 数字
 *       正则匹配 字母
 *
 * @author yzm
 * @date 2024/6/10 
 */
public class NumberAndChar {

    public static void main(String[] args) {
        String content = "13dasdfqeq124124zx131Java24fsfd";

        // 1、数字匹配
        String regex1 = "[0-9]+";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(content);
        while (matcher1.find()) {
            System.out.println(matcher1.group(0));
        }

        System.out.println("----------------------");

        // 2、单词匹配
        String regex2 = "[a-zA-Z]+";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(content);
        while (matcher2.find()) {
            System.out.println(matcher2.group(0));
        }

        System.out.println("----------------------");

        // 3、数字与单词
        String regex3 = "([0-9]+)|([a-zA-Z]+)";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(content);
        while (matcher3.find()) {
            System.out.println(matcher3.group(0));
        }
    }
}
