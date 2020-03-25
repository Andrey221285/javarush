package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = bis.readLine();
            if(s.equalsIgnoreCase("exit")){

                throw new InterruptOperationException();
            }
        } catch (IOException e) {
        }
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String s = "";
        do {
            writeMessage(res.getString("choose.currency.code"));

            s = readString();
            if (s.length() != 3) {
                writeMessage("Ошибка ввода!");
            }
        }
        while (s.length() != 3);

        return s.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] digit = new String[2];
        String s = "";
        int a = -1;
        int b = -1;
        do {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));

            s = readString();
            digit = s.split(" ");
            try {
                a = Integer.parseInt(digit[0]);
                b = Integer.parseInt(digit[1]);
                if (a <= 0 || b <= 0) {
                    writeMessage("Ошибка ввода!");
                }
            } catch (NumberFormatException e) {
                writeMessage("Ошибка ввода!");
            } catch (ArrayIndexOutOfBoundsException arr) {
                writeMessage("Ошибка ввода!");
            }
        }
        while (!(a > 0 && b > 0));
        return digit;
    }
    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage(String.format("1 - %s\n2 - %s\n3 - %s\n4 - %s",res.getString("operation.INFO"),res.getString("operation.DEPOSIT"),
                res.getString("operation.WITHDRAW"),res.getString("operation.EXIT")));

        Operation operation = null;

        do{
            try {
                operation =  Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException e) {
                writeMessage("Ошибка ввода!");
            }
            catch (IllegalArgumentException il){
                writeMessage("Ошибка ввода!");
            }
        }
        while(operation==null);
        return  operation;
    }
    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
