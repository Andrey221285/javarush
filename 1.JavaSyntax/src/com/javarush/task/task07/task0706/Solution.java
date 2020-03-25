package com.javarush.task.task07.task0706;

import java.io.*;
/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
     int even = 0;
     int odd = 0;
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
     int []street =new int[15];
     for(int i = 0;i<street.length;i++){
         street[i] = Integer.parseInt(key.readLine()); //заполняем массив данными
     }
     for (int b=0;b<street.length;b+=2){
        even += street[b];
     }
     for (int c = 1;c<street.length;c+=2){
         odd+=street[c];
     }
       if(even>odd){
         System.out.println("В домах с четными номерами проживает больше жителей.");
       }
       else{
           System.out.println("В домах с нечетными номерами проживает больше жителей.");
       }

    }
}
