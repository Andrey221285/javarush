package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
        System.out.println();
        printDate("9.10.2017 5:56:45");

    }

    public static void printDate(String date) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("H:m:s");

        if(date.contains(" ")){
            LocalDate localDate = LocalDate.parse(date.split(" ")[0], formatDate);
            LocalTime localTime = LocalTime.parse(date.split(" ")[1], formatTime);
            print1(localDate);
            print2(localTime);
        }
        else if(date.contains(":")){
            LocalTime localTime = LocalTime.parse(date, formatTime);
            print2(localTime);
        }
        else{
            LocalDate localDate = LocalDate.parse(date,formatDate);
            print1(localDate);
        }
    }
    public static void print1(LocalDate localDate){
        System.out.println("День: " + localDate.getDayOfMonth());
        System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
        System.out.println("День месяца: " + localDate.getDayOfMonth());
        System.out.println("День года: " + localDate.getDayOfYear());
        System.out.println("Неделя месяца: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH)));
        System.out.println("Неделя года: " + (localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR)));
        System.out.println("Месяц: " + localDate.getMonthValue());
        System.out.println("Год: " + localDate.getYear());
    }
    public static void print2(LocalTime localTime){
        System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
        System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
        System.out.println("Часы дня: " + localTime.get(ChronoField.HOUR_OF_DAY));
        System.out.println("Минуты: " + localTime.getMinute());
        System.out.println("Секунды: " + localTime.getSecond());
    }
}
