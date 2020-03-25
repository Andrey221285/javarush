package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix((short)2,3,value);

    }
    public static void printMatrix(short m, int n,Object value){
        System.out.println("pervi");
        printMatrix(m,(short)n, value);
    }
    public static void printMatrix(short m, short n, Object value){
        System.out.println("vtoroy");
        printMatrix((byte)m,n,value);
    }
    public static void printMatrix(byte m, short n, Object value){
        System.out.println("tretiy");
        printMatrix(m,(byte)n,value);
    }
    public static void printMatrix(byte m, byte n, Object value){
        System.out.println("chetvertiy");
        printMatrix(m,n,(String)value);
    }
    public static void printMatrix(byte m, byte n, String value){
        System.out.println("pyatiy");
        printMatrix(m,n,(Integer.parseInt(value)));
    }
    public static void printMatrix(byte m, byte n, Integer value){
        System.out.println("shestoy");
        printMatrix(m,n,(double)value);
    }
    public static void printMatrix(byte m, byte n, double value){
        System.out.println("sedmoi");
        printMatrix(m,n,(float)value);
    }
    public static void printMatrix(byte m, byte n, float value){
        System.out.println("vosmoi");
       // printMatrix(m,n,(float)value);
    }

}
