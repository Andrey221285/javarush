package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList<>());
        Horse one = new Horse("first", 3, 0);
        Horse two = new Horse("second", 3, 0);
        Horse three = new Horse("thirty", 3, 0);
        game.getHorses().add(one);
        game.getHorses().add(two);
        game.getHorses().add(three);

        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for(int i=0;i<100;i++){
            move();
            print();
            try{
            Thread.sleep(200);}
            catch(InterruptedException interruptedExeption){
                System.out.println(interruptedExeption.getMessage());
            }
        }
    }

    public void move() {
        for(Horse h:horses){
            h.move();
        }
    }

    public void print() {
        for(Horse h:horses){
            h.print();
        }
        for(int i=0;i<10;i++){
            System.out.println();
        }

    }
    public Horse getWinner(){
        Horse s = null;
        double max=0;
        for(Horse h:horses){
            if(h.getDistance()>max){
                s=h;
                max = h.getDistance();
            }
        }
        return s;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name+"!");
    }
}
