package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){

        if(denominations.containsKey(denomination)){
            denominations.put( denomination, denominations.get(denomination)+count);
        }
        else{
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int a = 0;
        for(Map.Entry<Integer, Integer> pair : denominations.entrySet()){
            a+=pair.getKey()*pair.getValue();
        }
        return a;
    }
    public boolean hasMoney(){
        if(denominations.size()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean isAmountAvailable(int expectedAmount){
        if(expectedAmount>getTotalAmount()){
            return false;
        }
        else {
            return true;
        }
    }
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer, Integer>copy = denominations;
        ArrayList<Integer> listkey = new ArrayList<>(copy.keySet());
        Collections.sort(listkey);
        Collections.reverse(listkey);
        int money =0;

        for(Integer key: listkey){
            for(int i=0;i<copy.get(key);i++){
                if (money+ key<=expectedAmount){
                    money +=key;
                    if(map.containsKey(key)){
                        map.put(key,map.get(key)+1);
                    }
                    else{
                        map.put(key,1);
                    }
                }
                else{
                    break;
                }
            }
        }
        if(money<expectedAmount){
            throw new NotEnoughMoneyException();
        }
        else{
            for(Map.Entry<Integer,Integer> pair : map.entrySet()){
                if(copy.get(pair.getKey())-pair.getValue()>0){
                    copy.put(pair.getKey(),copy.get(pair.getKey())-pair.getValue());
                }
                else{
                    copy.remove(pair.getKey());
                }
            }
        }

        return map;
    }
}
