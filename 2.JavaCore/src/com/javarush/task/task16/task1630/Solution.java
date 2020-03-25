package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
         secondFileName = reader.readLine();
        } catch (IOException e) {
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String filename;
        private String text = "";


        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String s;
                while ((s = br.readLine()) != null) {
                    text = text + s + " ";

                }



            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        public void setFileName(String fullFileName) {
            filename = fullFileName;

        }

        public String getFileContent() {
            return text.trim();
        }

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
