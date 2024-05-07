package com.yzm.函数式编程;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/7
 */
public class TriFunctionTest {

    public static void main(String[] args) {

        TriFunction<String, String, String, Integer> allLenFunction =
                (str1, str2, str3) -> str1.length() + str2.length() + str3.length();
        System.out.println("all length:" + allLenFunction.apply("Apple", "Orange", "Banana"));

        TriFunction<String, String, String, String> append =
                (str1, str2, str3) -> str1 + str2 + str3;
        System.out.println(append.apply("Apple", "Orange", "Banana"));

    }
}
