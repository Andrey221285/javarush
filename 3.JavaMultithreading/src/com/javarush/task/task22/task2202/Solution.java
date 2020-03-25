package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null){
            throw new TooShortStringException();
        }
        String[]s=string.split(" ");
        if(s.length<5){
            throw new TooShortStringException();
        }
        // String s = "";
        try {
            int start = string.indexOf(" ") + 1;
            int four = 0;
            for (int i = 0; i < 4; i++) {
                four = string.indexOf(" ", four) + 1;
            }
            if (string.indexOf(" ", four) != -1) {
                return string.substring(start, string.indexOf(" ", four));
            } else {
                return string.substring(start);
            }
        } catch (RuntimeException e) {
            throw new TooShortStringException();

        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
