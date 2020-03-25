package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[5];
        for (int b = 0; b < 5; b++) {
            array[b] = Integer.parseInt(reader.readLine());
        }
        for (int n=array.length-1;n>=0;n--) {
            for (int m = 0; m < n; m++) {
                if (array[m] > array[m + 1]) {
                    int temp = array[m];
                    array[m] = array[m+1];
                    array[m+1] = temp;
                }
            }
        }


        for (int j : array) {
            System.out.println(j);
        }

        //напишите тут ваш код
    }
}

