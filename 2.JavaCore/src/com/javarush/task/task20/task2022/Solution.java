package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        stream.close();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.stream = new FileOutputStream(fileName, true);


    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution sol = new Solution("d:\\test.txt");
        sol.writeObject("sesfdfgrtht");
        sol.writeObject("fbdfgfg");

        FileOutputStream fileout = new FileOutputStream("d:\\test2.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileout);
        out.writeObject(sol);

        FileInputStream filein = new FileInputStream("d:\\test2.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        sol = (Solution) in.readObject();
        sol.writeObject("2123342334,  32432423434");
    }
}
