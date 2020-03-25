package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        String one;
        String two;
        String three;

        public void run() {
            try {
                one = Solution.reader.readLine();
                two = Solution.reader.readLine();
                three = Solution.reader.readLine();
            } catch (IOException I) {
                System.out.println("ошибка ввода");
            }

        }
        public void printResult(){
            System.out.println(one + " " + two + " " + three);
        }
    }
}
