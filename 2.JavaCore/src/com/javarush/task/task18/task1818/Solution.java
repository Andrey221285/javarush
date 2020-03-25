package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2  = reader.readLine();
            String file3 = reader.readLine();
            FileOutputStream out = new FileOutputStream(file1);
            FileInputStream input1 = new FileInputStream(file2);
            FileInputStream input2 = new FileInputStream(file3);

            byte[] bufer = new byte[input1.available()];
            input1.read(bufer);
            out.write(bufer);
            byte []bufer1 = new byte[input2.available()];
            input2.read(bufer1);
            out.write(bufer1);

            reader.close();
            out.close();
            input1.close();
            input2.close();

        }
        catch(IOException i){
            System.out.println("IOException");
        }

    }
}
