package com.yzm.String;

/**
 * @author yanzhenming
 * @date 2023/4/14  16:10
 */

/**
 * 1、replace() 和 replaceAll() 都是常用的替换字符串的方法
 * 2、两者都是全部替换，可以把源字符串中的某一字符或字符串全部换成指定的字符或字符串
 * 3、如果只想替换第一次出现的，可以使用 replaceFirst()
 * 4、replaceAll() 和 replaceFirst() 所用的替换参数可以是普通字符串，也可以是正则表达式
 *
 */
public class ReplaceAndReplaceAll {
    public static void main(java.lang.String[] args) {
        java.lang.String str1 = "Aoc.Iop.Aoc.Iop.Aoc";	    //定义三个一样的字符串
        java.lang.String str2 = "Aoc.Iop.Aoc.Iop.Aoc";
        java.lang.String str3 = "Aoc.Iop.Aoc.Iop.Aoc";

        java.lang.String str11 = str1.replace(".", "#");	    // str11 = "Aoc#Iop#Aoc#Iop#Aoc"
        java.lang.String str22 = str2.replaceAll(".", "#");	    // str22 = "###################"    .是正则，这里是正则替换
        java.lang.String str33 = str3.replaceFirst(".", "#");	    // str33 = "#oc.Iop.Aoc.Iop.Aoc"
        System.out.println(str11);
        System.out.println(str22);
        System.out.println(str33);

        java.lang.String string = new java.lang.String();
        System.out.println(string.printString());
    }
}
