package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
ConsoleHelper.writeMessage(res.getString("before"));
        String code  = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int a = -1;

        do{
            ConsoleHelper.writeMessage(res.getString("specify.amount"));

            try {
                a = Integer.parseInt(ConsoleHelper.readString());

                if (currencyManipulator.isAmountAvailable(a)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),a,code));
                    for (Map.Entry<Integer, Integer> pair : (currencyManipulator.withdrawAmount(a)).entrySet()) {
                        System.out.println("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));

                    a = -1;
                }
            }
            catch(NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                a=-1;
            }
        }

        while(a<0);



    }
}
