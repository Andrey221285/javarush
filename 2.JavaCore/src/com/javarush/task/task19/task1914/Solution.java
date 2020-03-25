package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String result = outputStream.toString();
        result=result.replaceAll("\r\n", "");
        String a = result.replaceAll(" ", "");
        a=
        a = a.substring(0, a.indexOf('='));
        int otvet= 0;


        if (a.indexOf('+') > 0) {
            int first = Integer.parseInt(a.substring(0, a.indexOf('+')));
            int second = Integer.parseInt(a.substring(a.indexOf('+') + 1));
            otvet = first+second;
        }
        if(a.indexOf('-')>0){
            int first = Integer.parseInt(a.substring(0, a.indexOf('-')));
            int second = Integer.parseInt(a.substring(a.indexOf('-') + 1));
            otvet = first-second;
        }
        if(a.indexOf('*')>0){
            int first = Integer.parseInt(a.substring(0, a.indexOf('*')));
            int second = Integer.parseInt(a.substring(a.indexOf('*') + 1));
            otvet = first*second;
        }


        System.out.println(result + otvet);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

