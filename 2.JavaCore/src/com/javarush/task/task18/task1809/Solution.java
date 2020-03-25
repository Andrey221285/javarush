package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            FileInputStream input = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);

            if (input.available() > 0) {
                byte[] bufer = new byte[input.available()];
                        input.read(bufer);

                for (int a = 0; a < bufer.length / 2; a++) {
                    byte temp = bufer[a];
                    bufer[a] = bufer[bufer.length - 1 - a];
                    bufer[bufer.length - 1 - a] = temp;
                }
                out.write(bufer);

            }
            reader.close();
            input.close();
            out.close();

        } catch (IOException e) {
            System.out.println("error input");
        }
    }
}
