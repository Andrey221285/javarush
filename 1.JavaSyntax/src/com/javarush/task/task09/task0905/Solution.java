package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        StackTraceElement[] el = Thread.currentThread().getStackTrace();
        int a = el.length;
        System.out.println(a);
        return a;//напишите тут ваш код
    }
}

