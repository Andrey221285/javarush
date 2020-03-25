package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\Andrey\\YandexDisk\\Java\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getUniqueIPs(null,new Date()));
        System.out.println(logParser.getIPsForUser("Amigo",null,new Date()));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null,null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
        System.out.println();
        System.out.println(logParser.execute("get status for date = \"12.12.2013 21:56:30\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}