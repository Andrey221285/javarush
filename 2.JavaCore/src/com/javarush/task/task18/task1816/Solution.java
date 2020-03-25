package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream(args[0])) {
            byte[] bufer = new byte[input.available()];
            input.read(bufer);
            int count = 0;
            for (byte b : bufer) {
                if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)){
                    count++;
                }
            }
            System.out.println(count);

        } catch (FileNotFoundException f) {
            System.out.println("filename is wrong");
        } catch (IOException i) {
            System.out.println("IO error");
        }
    }
}
