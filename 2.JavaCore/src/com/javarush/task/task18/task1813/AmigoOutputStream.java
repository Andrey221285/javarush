package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileout;

    public AmigoOutputStream(FileOutputStream fileout) throws FileNotFoundException {
        super(fileName);
        this.fileout = fileout;
    }

    @Override
    public void write(int b) throws IOException {
        fileout.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileout.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileout.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        fileout.flush();
    }

    @Override
    public void close() throws IOException {
        fileout.flush();
        write("JavaRush © All rights reserved.".getBytes());


        fileout.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
