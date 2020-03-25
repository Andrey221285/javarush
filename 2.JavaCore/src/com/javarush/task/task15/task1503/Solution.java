package com.javarush.task.task15.task1503;

/* 
ООП - машинки
*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }
    public static class LuxuriousCar {
        String a = Constants.WANT_STRING;
        protected String b = Constants.LUXURIOUS_CAR;
        private  void printlnDesire() {
            //add your code here
            System.out.println(a + b);
        }

    }
    public static class CheapCar{
        String a = Constants.WANT_STRING;
        protected String b = Constants.CHEAP_CAR;
        private void printlnDesire() {
            //add your code here
            System.out.println(a+b);
        }

    }


    public static class Ferrari extends LuxuriousCar {
        public String b = Constants.FERRARI_NAME;
        public void printlnDesire() {
            //add your code here
            System.out.println(a + b);
        }
    }

    public static class Lanos extends CheapCar {
        public String b = Constants.LANOS_NAME;
        public void printlnDesire() {
            //add your code here
            System.out.println(a + b);
        }
    }

    public static class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARI_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";
    }
}
