package com.yzm.常量池;


/**
 * ***** StringTable 字符串常量池:
 *
 *          1、常量池中的字符串仅是符号，第一次用到时才会变成对象存在StringTable，如果是new String("a")，会在堆和StringTable创建两个对象
 *                  - 例如 String s = "a"; 在没执行到这行代码时，StringTable只存在"a"这个符号，
 *                      在执行到这一行时，会在StringTable创建一个对象
 *                  - 而 String s = new String("a")，在没执行到这行代码时，StringTable只存在"a"这个符号，
 *                      在执行到这一行时，会在StringTable和堆中创建一个对象
 *                  - 而 String s6 = new String("a") + new String("b"); 在没执行到这行代码时，StringTable只存在"a"，"b"这个符号，
 *                      在执行到这一行时，会在StringTable创建a、b对象，会在堆创建a、b、ab三个对象
 *          2、利用字符串常量池，避免重复创建
 *          3、字符串变量拼接原理是StringBuilder的tostring方法，tosting会new String存在堆里面
 *          4、字符串常量拼接原理是编译期优化
 *          5、主动使用intern方法将字符串加入字符串常量池，常量池有值时，无法加入
 *
 *
 *          注：StringTable长度固定，是stringtable结构
 *
 * @author 颜真明
 * @date 2024/3/24  17:56
 */
public class StringTableTest {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        // 字符串变量拼接原理是StringBuilder的tostring方法，tosting会new String存在堆里面
        String s4 = s1 + s2;
        // 字符串常量拼接原理是编译期优化
        String s5 = "a" + "b";
        System.out.println(s3==s4);
        System.out.println(s3==s5);

        // 此时m、n在StringTable和堆中各有一份，mn只存在于堆中
        String s6 = "m" + "n";
        // 放入StringTable
        s6.intern();
        String s7 = "mn";
        System.out.println(s6 == s7);

        String s8 = "m" + "n";
        // 常量池中存在mn，此时不会s8加入不了常量池
        s8.intern();
        System.out.println(s7 == s8);

    }
}
