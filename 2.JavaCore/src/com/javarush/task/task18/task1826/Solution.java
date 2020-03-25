package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int key = 17;

        try(FileInputStream input = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2])){
            byte[]bufer = new byte[input.available()];
            input.read(bufer);
            if(args[0].equals("-e") || args[0].equals("-d")){
                for(int m = 0;m<bufer.length;m++){
                    bufer[m]=(byte)(bufer[m]^key);
                }
                out.write(bufer);
            }

        }
        catch (FileNotFoundException f){
            System.out.println("file not found");
        }
        catch(IOException i){
            System.out.println("IO Error");
        }

    }

}
