package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();}
            catch (IOException e){
                System.out.println("файла не существует");
            }
            try{
            BufferedReader filereader = new BufferedReader(new FileReader(file1));
            String s;
            while ((s = filereader.readLine()) != null) {
                allLines.add(s);
            }
            filereader = new BufferedReader((new FileReader(file2)));
            while ((s = filereader.readLine()) != null) {
                forRemoveLines.add(s);
            }
            filereader.close();
        } catch (IOException e) {
            System.out.println("сбой чтения файла");
        }

        try{
        Solution s = new Solution();
        s.joinData();}
        catch (CorruptedDataException e){
            System.out.println("разные данные");
        }
       // System.out.println(allLines);
      //  System.out.println(forRemoveLines);

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
           throw new CorruptedDataException();
        }


    }
}
