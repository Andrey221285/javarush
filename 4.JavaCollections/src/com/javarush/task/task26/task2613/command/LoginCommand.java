package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;


import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
  
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");


    @Override
    public void execute() throws InterruptOperationException {
        boolean flag = true;
        do {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            String loginUser = ConsoleHelper.readString();
            String pinUser = ConsoleHelper.readString();

            if (loginUser.length()==12 && pinUser.length()==4) {
                if (validCreditCards.containsKey(loginUser) && validCreditCards.getString(loginUser).equals(pinUser)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),loginUser));
                    flag = false;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),loginUser));
                   ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
        while (flag);
    }
}
