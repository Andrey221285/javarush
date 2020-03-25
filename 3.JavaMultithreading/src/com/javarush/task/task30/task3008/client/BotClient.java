package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(": ")) {
                //тело метода

                String userName = message.substring(0, message.indexOf(":")).trim();
                String data = message.substring(message.indexOf(":") + 1).trim();
                Calendar c = new GregorianCalendar();
                SimpleDateFormat dateFormat;

                switch (data) {
                    case ("дата"):
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("день"):
                        dateFormat = new SimpleDateFormat("d");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("месяц"):
                        dateFormat = new SimpleDateFormat("MMMM");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("год"):
                        dateFormat = new SimpleDateFormat("YYYY");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("время"):
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("час"):
                        dateFormat = new SimpleDateFormat("H");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("минуты"):
                        dateFormat = new SimpleDateFormat("m");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                    case ("секунды"):
                        dateFormat = new SimpleDateFormat("s");
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(c.getTime()));
                        break;
                }
            }
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
