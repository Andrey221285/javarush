package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String zipFile = args[1];
        HashMap<String, ByteArrayOutputStream> temp = new HashMap<>();
        File file = new File(fileName);

     try( ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))){
         ZipEntry ze;
         while ((ze=zis.getNextEntry()) != null) {
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             byte[] buffer = new byte[1024];
             int count = 0;
             while ((count = zis.read(buffer)) != -1)
                 baos.write(buffer, 0, count);
             temp.put(ze.getName(), baos);
         }
     }

       try( ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))){
           for (Map.Entry<String, ByteArrayOutputStream> item : temp.entrySet()) {

               if (item.getKey().substring(item.getKey().lastIndexOf("/") + 1).equals(file.getName())) {
                   continue;
               }
               ZipEntry zipEntry = new ZipEntry(item.getKey());
               zos.putNextEntry(zipEntry);
               zos.write(item.getValue().toByteArray());

           }
           ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
           zos.putNextEntry(zipEntry);
           Files.copy(file.toPath(), zos);

       }

    }
}
