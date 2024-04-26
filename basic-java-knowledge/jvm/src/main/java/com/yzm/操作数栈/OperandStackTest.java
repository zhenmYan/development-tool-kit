package com.yzm.操作数栈;

/**
 * description:
 *
 *      a++先执行iload字节码指令，然后执行iinc指令
 *      ++a限制性iinc字节码指令，然后执行iload指令
 *
 *      innc会在槽位进行操作，iload会将值加入到操作数栈
 *
 * @author 颜真明
 * @date 2024/3/27  17:49
 */
public class OperandStackTest {
    public static void main(String[] args) {
        int a1 = 10, a2 = 10, a3 = 10;
        // 结果为22
        int b = a1++ + ++a1;
        // 结果为34
        int c = a2++ + ++a2 + a2--;
        // 结果为44
        int d = a3++ + ++a3 + a3-- + --a3;

        int i = 0, x = 0;
        while (i < 10) {
            x = x++;
            i++;
        }

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(x);
    }
}
