package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        Solution sol = new Solution();

        File old = new File(resultFileAbsolutePath);
        File out = new File(old.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(old)) {
            FileUtils.renameFile(old, out);
        }
        sol.getFileList(path);
        Collections.sort(sol.fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        try (FileOutputStream fileOutputStream = new FileOutputStream(out)) {
            for (File f : sol.fileList) {
                try (FileInputStream fileInputStream = new FileInputStream(f)) {
                    byte[] bufer = new byte[fileInputStream.available()];
                    fileInputStream.read(bufer);
                    fileOutputStream.write(bufer);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (FileNotFoundException ff) {
            System.out.println(ff.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    ArrayList<File> fileList = new ArrayList<>();

    public void getFileList(String s) {

        File file = new File(s);
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                if (f.length() <= 50) {
                    fileList.add(f);
                }
            } else if (f.isDirectory()) {
                getFileList(f.getAbsolutePath());
            }
        }
    }

}
