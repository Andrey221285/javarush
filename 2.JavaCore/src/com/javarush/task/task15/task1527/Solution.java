package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            s = s.substring(s.indexOf("?") + 1);
            String[] word = s.split("&");
            String parametr = "";
            for (String a : word) {
                if (a.indexOf("=") == -1) {
                    parametr += a + " ";
                } else {
                    parametr += (a.substring(0, a.indexOf("=")) + " ");
                }
            }
            System.out.println(parametr);
            for (String a : word) {
                if((a.indexOf("obj") != -1) && a.indexOf("=") != -1){
                    String b = a.substring(a.indexOf("=")+1);
                    try{
                        alert(Double.parseDouble(b));
                    }
                    catch(Exception e){
                        alert(b);
                    }
                }
            }

            //add your code here
        } catch (IOException e) {
            System.out.println("чтото не так пошло");
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
