package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        for(int a =0; a<40;a++){
            String s1 = s;
            s1=s1.substring(a);
            s1=s1.trim();
            System.out.println(s1);
        }





        //напишите тут ваш код
    }

}

