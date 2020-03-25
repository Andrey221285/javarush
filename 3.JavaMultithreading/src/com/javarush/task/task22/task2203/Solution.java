package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
String ss="";
        if(string ==null || string.isEmpty()){
            throw new TooShortStringException();
        }
        try {

            String[] s=string.split("\t");
            if(s.length<3){
                throw new TooShortStringException();
            }
            ss= s[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }
return ss;

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
       // System.out.println(getPartOfString("\tfdhgjh"));
    }
}
