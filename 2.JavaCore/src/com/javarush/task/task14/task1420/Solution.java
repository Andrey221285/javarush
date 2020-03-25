package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if (a<=0 ||b<=0){
          throw new IllegalArgumentException();
        }
        int NOD = 1;
        int k = 1;
        while (a!=0 && b!=0) {
            if (a % 2 == 0 && b % 2 == 0) {
                while (a % 2 == 0 && b % 2 == 0) {
                    a = a / 2;
                    b = b / 2;
                    k = k * 2;
                }
            }
            if (a%2==0 && b%2!=0){
                while(a%2==0){
                    a = a/2;
                }
            }
            if (b%2==0 && a%2!=0){
                while(b%2==0){
                    b = b/2;
                }
            }
            if (a>=b) a-=b;

            else b-=a;


        }
        NOD = b*k;



        System.out.println(NOD);


    }
}
