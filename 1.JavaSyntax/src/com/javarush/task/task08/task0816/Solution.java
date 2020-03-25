package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Andreev", new Date("NOVEMBER 4 1983"));
        map.put("Petrov", new Date("JULY 17 1988"));
        map.put("Ivanov", new Date("AUGUST 4 1988"));
        map.put("Sidorov", new Date("OCTOBER 9 1987"));
        map.put("Alekseev", new Date("DECEMBER 22 1985"));
        map.put("Pimenov", new Date("MARCH 8 1989"));
        map.put("Atamanov", new Date("APRIL 23 1982"));
        map.put("Volkov", new Date("JANUARY 12 1981"));
        map.put("Egorov", new Date("MAY 12 1984"));

        return map;//напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        HashMap<String, Date> mapcopy = new HashMap(map);
        for (HashMap.Entry<String, Date> pair : mapcopy.entrySet()){
            if(4<pair.getValue().getMonth() && pair.getValue().getMonth()<8){
             map.remove(pair.getKey());
           }
                    }

    }

    public static void main(String[] args) {

    }
}
