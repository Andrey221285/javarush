package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {

        for(int a=array.length-1;a>=0;a--){
            for(int b=0;b<a;b++){
                if(array[b]<array[b+1]){
                    int temp=array[b];
                    array[b]=array[b+1];
                    array[b+1]=temp;

                }
            }
        }

    }
}
