package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String name = "Иванов Иван Иванович 31 12 1950";

        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));

        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person p = null;
            if (this.fileScanner.hasNext()) {
                String s = this.fileScanner.nextLine();

                String[] bufer = s.split(" ");
                int year = Integer.parseInt(bufer[5]);
                int month =Integer.parseInt(bufer[4])-1;
                int day = Integer.parseInt(bufer[3]);
                GregorianCalendar calendar = new GregorianCalendar(year, month, day);
                Date date = calendar.getTime();



                p = new Person(bufer[1], bufer[2], bufer[0],date);
            }
            return  p;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
