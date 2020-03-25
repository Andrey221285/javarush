package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());

        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());//напишите тут ваш код
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> catdog = new HashSet<Object>();//напишите тут ваш код
        for(Cat c : cats){
            catdog.add(c);
        }
        for(Dog d : dogs){
            catdog.add(d);
        }
        return catdog;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        for (Cat c : cats){
            pets.remove(c);//напишите тут ваш код
        }
    }

    public static void printPets(Set<Object> pets) {
        for(Object o : pets){
            System.out.println(o);//напишите тут ваш код
        }
    }
    public static class Cat {

    }
    public static class Dog{

    }

    //напишите тут ваш код
}
