package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap;

    static {
        connectionMap = new ConcurrentHashMap();
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> con : connectionMap.entrySet()) {
                con.getValue().send(message);
            }
        } catch (IOException i) {
            System.out.println("не получилось отправить сообщение");
        }
    }

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Установлено новое соединенис с: " + socket.getRemoteSocketAddress());
            String userName = null;
            try {
                Connection connect = new Connection(socket);
                userName = serverHandshake(connect);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connect, userName);
                serverMainLoop(connect, userName);
            }
            catch (IOException io){
                if(userName!=null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
            }
            catch (ClassNotFoundException cf){
                if(userName!=null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
            }
            if(userName!=null){
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            }
            ConsoleHelper.writeMessage("соединение с удаленным адресом закрыто");

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {
                Message mes = connection.receive();

                if (mes.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + mes.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (Map.Entry<String, Connection> list : connectionMap.entrySet()) {
                if (!(list.getKey().equals(userName))) {
                    connection.send(new Message(MessageType.USER_ADDED, list.getKey()));
                }
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            Message mes = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "введите имя"));
                mes = connection.receive();

                if (mes.getType() == MessageType.USER_NAME) {

                    if (mes.getData().isEmpty()) {
                        continue;
                    }
                    if (connectionMap.containsKey(mes.getData())) {
                        continue;
                    }
                    break;
                }
            }
            connection.send(new Message(MessageType.NAME_ACCEPTED, "имя принято"));
            connectionMap.put(mes.getData(), connection);
            return mes.getData();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите номер порта:");
        int port = ConsoleHelper.readInt();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            System.out.println("Сервер запущен");
            while (true) {
                new Handler(ss.accept()).start();

            }
        } catch (Exception i) {
            try {
                ss.close();
            } catch (IOException ii) {
            }
            System.out.println(i.getMessage());
        }


    }
}
