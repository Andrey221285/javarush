package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[]s=new Solution[2];
        Solution one = new Solution();
        one.innerClasses[0]=one.new InnerClass();
        one.innerClasses[1]=one.new InnerClass();
        s[0]=one;
        Solution two = new Solution();
        two.innerClasses[0]=one.new InnerClass();
        two.innerClasses[1]=one.new InnerClass();
        s[1]=two;

        return s;
    }

    public static void main(String[] args) {

    }
}
