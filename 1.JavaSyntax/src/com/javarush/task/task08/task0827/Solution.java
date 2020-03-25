package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date current = new Date(date);
        current.setSeconds(1);

        Date start = new Date();

        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);

        start.setDate(0);
        start.setMonth(0);
        start.setYear(current.getYear());
        long msTimeDistance=current.getTime()-start.getTime();
        long msDay=24*60*60*1000;
        int day = (int)(msTimeDistance/msDay);


        if(day%2==0)
            return false;
        else
            return true;

    }
}
