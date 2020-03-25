package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Иванов","Иван");
        map.put("Петров","Иван");
        map.put("Иванов","Андрей");
        map.put("Петров","Петр");
        map.put("Зайцев","Петр");
        map.put("Дунькин","Дима");
        map.put("Дмитриев","Алексей");
        map.put("Алексеев","Дима");
        map.put("Белкин","Саня");
        map.put("Максимов","Макс");//напишите тут ваш код

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
