package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        Queue<File> fileTree = new PriorityQueue<>();
        List<String> fileList = new ArrayList<>();
        Collections.addAll(fileTree, rootDir.listFiles());
        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
                if (currentFile.isDirectory()) {
                    Collections.addAll(fileTree, currentFile.listFiles());
                } else if (currentFile.isFile()) {
                    fileList.add(currentFile.getAbsolutePath());
                }


        }
        return fileList;

    }

    public static void main(String[] args) {
        try {
            List<String> list = getFileTree("d:/work");
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
