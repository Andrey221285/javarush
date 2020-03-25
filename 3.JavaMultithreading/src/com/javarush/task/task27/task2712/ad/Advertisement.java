package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;                 //видео
    private String name;                    //имя/название
    private long initialAmount;             //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;                       //количество оплаченных показов
    private int duration;                   //продолжительность в секундах
    private long amountPerOneDisplaying;    //стоимости одного показа рекламного объявления в копейках (initialAmount/hits).

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0) {
            this.amountPerOneDisplaying = initialAmount / hits;
        }
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public Advertisement(long amountPerOneDisplaying) {
        this.amountPerOneDisplaying = amountPerOneDisplaying;
    }

    public void revalidate(){
        if(hits<=0){
            throw new UnsupportedOperationException();
        }
        else{
            hits--;
        }
    }
    public String toString(){
        return String.format("%s is displaying... %d, %d",name, amountPerOneDisplaying, (long)(amountPerOneDisplaying * 1000.0/ duration));
    }
}
