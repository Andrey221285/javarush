package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length > 0 && args[0].length() < 256) {
                boolean is = true;
                char[] chars = args[0].toCharArray();
                for (char c : chars) {
                    if ((int) c < 32 && (int) c > 127) {
                        is = false;
                    }
                }
                if (is) {
                    int m = 0;

                    try {
                        for (int j = 36; j >=2; j--) {
                            new BigInteger(args[0], j);
                            m = j;

                        }
                    } catch (NumberFormatException y) {
                    }
                    if (m > 0) {
                        System.out.println(m);
                    } else {
                        System.out.println("incorrect");
                    }

                } else {
                    System.out.println("incorrect");
                }
            }
        } catch (Exception n) {}
        //напишите тут ваш код
    }
}