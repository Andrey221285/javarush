package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean work = true;
        while(work){
            try {
                String filename = reader.readLine();
                FileInputStream input = new FileInputStream(filename);
                if (input.available()<1000){
                    input.close();
                    reader.close();
                    work=false;
                    throw new DownloadException();
                }

            }
            catch (IOException e){}

        }
    }

    public static class DownloadException extends Exception {

    }
}
