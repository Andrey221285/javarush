package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean isName = true;
        boolean isContent = true;
        boolean isMin = true;
        boolean isMax = true;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            isName = false;
        }
        String ss = new String(Files.readAllBytes(file));
        if (partOfContent != null && !(ss.contains(partOfContent))) {
            isContent = false;
        }
        if (minSize > -1 && !(content.length >= minSize)) {
            isMin = false;
        }
        if (maxSize > -1 && !(content.length <= maxSize)) {
            isMax = false;
        }

        if (isName && isContent && isMin && isMax) {
            foundFiles.add(file);
        }
  /*      if (partOfName != null && partOfContent != null && minSize > -1 && maxSize > -1) {
            if (((file.getFileName()).toString()).contains(partOfName)) {
                String s = new String(content);
                if (s.contains(partOfContent)) {
                    if (content.length >= minSize && content.length <= maxSize) {
                        foundFiles.add(file);
                    }
                }
            }
        }*/
        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
