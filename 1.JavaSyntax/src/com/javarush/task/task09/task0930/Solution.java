package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        for(int a=array.length-1;a>=0;a--){
            for(int b=0;b<a;b++){
                if(isNumber(array[b])){
                    int x1=Integer.parseInt(array[b]);
                    int x2=0;
                    int j=b+1;
                    for(int c=j;c<array.length;c++){
                        if(isNumber(array[c])){
                            x2=Integer.parseInt(array[c]);
                            j=c;
                            break;
                        }
                    }
                    if(x1<x2){
                        String temp = array[b];
                        array[b] = array[j];
                        array[j] = temp;
                    }
                }
                else{
                    String s1 = array[b];
                    String s2 = "";
                    int j=b+1;
                    for (int c=j;c<array.length;c++){
                        if(isNumber(array[c])==false){
                            s2=array[c];
                            j=c;
                            break;
                        }
                    }
                    if(isGreaterThan(s1,s2)){
                        String temp = array[b];
                        array[b]=array[j];
                        array[j]=temp;
                    }
                }


            }
        }


    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
