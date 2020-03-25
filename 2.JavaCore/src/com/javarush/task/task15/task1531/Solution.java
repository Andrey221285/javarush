package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String fact = "";
        if (n < 0) {
            return fact + 0;
        } else if (n == 0) {

            return fact + 1;
        } else {
            BigDecimal big = new BigDecimal(1);
            for(int i=1;i<=n;i++){
                BigDecimal big2 = new BigDecimal(i);
                big = big.multiply(big2);
            }
            return fact+big;
        }


    }
}

