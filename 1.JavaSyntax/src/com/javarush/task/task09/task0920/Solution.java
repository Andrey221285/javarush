package com.javarush.task.task09.task0920;

/* 
Обратный отсчёт
*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
      try {
          for (int i = 10; i >= 0; i--) {
              System.out.println(i);
              Thread.sleep(100);
          }
      }
        catch(Exception f){

           }
            //напишите тут ваш код
        }
    }

