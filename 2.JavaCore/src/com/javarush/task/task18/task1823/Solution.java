package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "";
            while (!((s = reader.readLine()).equals("exit"))) {
                ReadThread r = new ReadThread(s);
                r.start();
            }
        } catch (IOException i) {
            System.out.println("IO error");
        }
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try (FileInputStream input = new FileInputStream(fileName)) {
                byte[] bufer = new byte[input.available()];
                input.read(bufer);
                Integer max = 0;
                int count = 0;
                for (byte b : bufer) {
                    int a = 0;
                    for (byte c : bufer) {
                        if (b == c) {
                            a++;
                        }
                    }
                    if (a > count) {
                        count = a;
                        max = (int) b;
                    }
                }
                synchronized (this){
                resultMap.put(fileName, max);}

            } catch (FileNotFoundException f) {
                System.out.println("file not found");
            } catch (IOException i) {
                System.out.println("IO Error");
            }

        }

    }
}
