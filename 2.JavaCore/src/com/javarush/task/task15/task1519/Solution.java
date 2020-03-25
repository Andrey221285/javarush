package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        while(!(s.equals("exit"))){
            try{
                Double a = Double.parseDouble(s);
                if(s.indexOf(".")!=-1) {
                    print(a);
                }
                else if (Integer.parseInt(s)>=128 || Integer.parseInt(s)<=0)
                    print(Integer.parseInt(s));
                else{
                    print((short)Integer.parseInt(s));
                }

            }
            catch(NumberFormatException e){
                print(s);
            }




            s=reader.readLine();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
