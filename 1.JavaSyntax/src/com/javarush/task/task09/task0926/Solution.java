package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<int[]>();//напишите тут ваш код
        list.add(new int[]{1,2,3,4,5});
        list.add(new int[]{66,55});
        list.add(new int []{44,33,345,53});
        list.add(new int[]{11,22,3232,123,123,43,34,});
        list.add(new int[0]);
        return list;
    }


    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
