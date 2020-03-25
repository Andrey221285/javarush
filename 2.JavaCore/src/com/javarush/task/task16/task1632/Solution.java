package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static{
        threads.add(new T1());
        threads.add(new T2());
        threads.add(new T3());
        threads.add(new T4());
        threads.add(new T5());

    }

    public static void main(String[] args) {
        T5 t = new T5();
        T3 t3 = new T3();
        t.start();

    }

    public static class T1 extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException i) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class T3 extends Thread {
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);

                } catch (InterruptedException i) {

                }
            }
        }
    }

    public static class T4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        public void run() {
            while (!isInterrupted()) {

            }
        }
    }

    public static class T5 extends Thread {
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int sum = 0;
                String s ;
                while (!((s=reader.readLine()).equals("N"))) {
                    sum+=Integer.parseInt(s);
                }
                System.out.println(sum);
            } catch (IOException I) {

            }
        }


    }

}